Design News Feed System (Part 1)
If you have followed our previous posts on system design interview questions, you might be surprised at how common news feed system is.

No matter whether you are building Twitter, Instagram or Facebook, you will need some sort of news feed systems to display updates from follows/friends.

In fact, there are a bunch of interesting details about news feed like how to rank feeds, how to optimize publishing etc.. So in this post, I’ll cover this popular question – design news feed system.

 

Question
To make it simple, let’s focus on designing news feed system for Facebook since different products have different requirements.

To briefly summarize the feature, when users go to their home pages, they will see updates from their friends based on particular order. Feeds can contain images, videos or just text and a user can have a large number of friends.

So how can you design such news feed system from scratch?

 

Subproblems
If you haven’t thought about this problem, it’s better to solve it by yourself before reading the rest of the post. Although there’s no such a thing as standard answer, you can still learn a lot by comparing your solution with others.

Here we go. As we said before, when facing such large and vague system design question, it’s better to have some high-level ideas by dividing the big problem into subproblem.

For a news feed system, apparently we can divide it into front-end and backend. I’ll skip the front-end as it’s not that common in system design interviews. For backend, three subproblems seem critical to me:

Data model. We need some schema to store user and feed object. More importantly, there are lots of trade-offs when we try to optimize the system on read/write. I’ll explain in details next.
Feed ranking. Facebook is doing more than ranking chronologically.
Feed publishing. Publishing can be trivial when there’re only few hundreds of users. But it can be costly when there are millions or even billions of users. So there’s a scale problem here.
 

Data model
There are two basic objects: user and feed. For user object, we can store userID, name, registration date and so on so forth. And for feed object, there are feedId, feedType, content, metadata etc., which should support images and videos as well.

If we are using a relational database, we also need to model two relations: user-feed relation and friend relation. The former is pretty straightforward. We can create a user-feed table that stores userID and corresponding feedID. For a single user, it can contain multiple entries if he has published many feeds.

For friend relation, adjacency list is one of the most common approaches. If we see all the users as nodes in a giant graph, edges that connect nodes denote friend relation. We can use a friend table that contains two userIDs in each entry to model the edge (friend relation). By doing this, most operations are quite convenient like fetch all friends of a user, check if two people are friends.



 

Data model – continue
In the design above, let’s see what happens when we fetch feeds from all friends of a user.

The system will first get all userIDs of friends from friend table. Then it fetches all feedIDs for each friend from user-feed table. Finally, feed content is fetched based on feedID from feed table. You can see that we need to perform 3 joins, which can affect performance.

A common optimization is to store feed content together with feedID in user-feed table so that we don’t need to join the feed table any more. This approach is called denormalization, which means by adding redundant data, we can optimize the read performance (reducing the number of joins).

The disadvantages are obvious:

Data redundancy. We are storing redundant data, which occupies storage space (classic time-space trade-off).
Data consistency. Whenever we update a feed, we need to update both feed table and user-feed table. Otherwise, there is data inconsistency. This increases the complexity of the system.
Remember that there’s no one approach always better than the other (normalization vs denormalization). It’s a matter of whether you want to optimize for read or write.

 

Ranking
The most straightforward way to rank feeds is by the time it was created. Obviously, Facebook is doing more than that. “Important” feeds are ranked on top.

Before jumping to the ranking algorithm, I’d usually like to ask why do we want to change the ranking? How do we evaluate whether the new ranking algorithm is better? It’s definitely impressive if candidates come up with these questions by themselves.

The reason to have better ranking is not that this seems the right thing to do. Instead, everything should happen for a reason. Let’s say there are several core metrics we care about, e.g. users stickiness, retention, ads revenue etc.. A better ranking system can significantly improve these metrics potentially, which also answers how to evaluate if we are making progress.

So back to the question – how should we rank feeds? A common strategy is to calculate a feed score based on various features and rank feeds by its score, which is one of the most common approaches for all ranking problems.

More specifically, we can select several features that are mostly relevant to the importance of the feed, e.g. share/like/comments numbers, time of the update, whether the feed has images/videos etc.. And then, a score can be computed by these features, maybe a linear combination. This is usually enough for a naive ranking system.

 

Summary
I didn’t expect to have so many details before writing this post and I had to cut the post in half.

In the second part, we’re going to cover more details about ranking, scalability issues with feed publishing and other interesting topics.

If you find this post helpful, I would really appreciate if you can share it with your friends. Also you can check more system design interview questions and analysis here.

What? Interview coaching from Googlers! 
system design interview questions
Design News Feed System (Part 2)
This is the 2nd part for system design interview question analysis – design news feed system. If you haven’t seen our first post, please go check it.

Just briefly summarize what we have discussed in part 1. We started with a simple question – how to design news feed system for Facebook that allows users see feeds/updates from friends. We modeled the whole system using relational database and talked about pros and cons of different design.

Ranking is an interesting topic for news feed system. We explained some general ideas of ranking in previous post. And in this post, we’ll continue the discussion ranking and also cover topics like feed publishing and so on.

Ranking – continue
The general idea of ranking is to first select features/signals that are relevant and then figure out how to combine them to calculate a final score. This approach is extremely common among lots of real-world systems.

As you can see that what matters here are two things – features and calculation algorithm. To give you a better idea of it, I’d like to briefly introduce how ranking actually works at Facebook – EdgeRank.

For each news update you have, whenever another user interacts with that feed, they’re creating what Facebook calls an Edge, which includes actions like like and comments.

First of all, let’s take a look at what features are used to evaluate the importance of an update/feed. Edge Rank basically is using three signals: affinity score, edge weight and time decay.

Affinity score (u). 
For each news feed, affinity score evaluates how close you are with this user. For instance, you are more likely to care about feed from your close friends instead of someone you just met once. You might ask how affinity score is calculated, I’ll talk about it soon.
Edge weight (e). 
Edge weight basically reflects importance of each edge. For instance, comments are worth more than likes.
Time decay (d). 
The older the story, the less likely users find it interesting.
So how does Facebook rank feeds by these three features? The calculation algorithm is quite straightforward. For each feed you create, multiply these factors for each Edge then add the Edge scores up and you have an update’s EdgeRank. And the higher that is, the more likely your update is to appear in the user’s feed.

Affinity score
We can do exactly the same thing to evaluate affinity score.

Various factors can be used to reflect how close two people are. First of all, explicit interactions like comment, like, tag, share, click etc. are strong signals we should use. Apparently, each type of interaction should have different weight. For instance, comments should be worth much more than likes.

Secondly, we should also track the time factor. Perhaps you used to interact with a friend quite a lot, but less frequent recently. In this case, we should lower the affinity score. So for each interaction, we should also put the time decay factor.

To sum up the ranking section, I hope this common approach for ranking can be one of your takeaways. Also, EdgeRank was first published at 2010 and it can be outdated.

Feed publishing
When a user loads all the feeds from his friends, it can be an extremely costly action. Remember that a user can have thousands of friends and each of them can publish a huge amount of updates especially for high profile users. To load all feeds from friends, the system requires at least two joins (get friends list and feed list.

So how to optimize and scale the feed publishing system?

Basically there are two common approaches here – push and pull.

For a push system, 
once a user has published a feed, we immediately pushing this feed (actually the pointer to the feed) to all his friends. The advantage is that when fetching feed, you don’t need to go through your friends list and get feeds for each of them. It significantly reduces read operation. However, the downside is also obvious. It increases write operation especially for people with a large number of friends.

For a pull system, 
feeds are only fetched when users are loading their home pages. So feed data doesn’t need to be sent right after it’s created. You can see that this approach optimizes for write operation, but can be quite slow to fetch data even after using denormalization (check our previous post if you don’t understand this).

Both approaches work well at certain circumstances and it’s always better to understand their pros and cons.

Selective fanout,
The process of pushing an activity to all your friends or followers is called a fanout. So the push approach is also called fanout on write, while the pull approach is fanout on load.

Here I’d like to ask if you have any approaches to further optimize the fanout process?

In fact, you can do a combination of both. Specifically, if you are mainly using push model, what you can do is to disable fanout for high profile users and other people can only load their updates during read. The idea is that push operation can be extremely costly for high profile users since they have a lot of friends to notify. By disabling fanout for them, we can save a huge number of resources. Actually Twitter has seen great improvement after adopting this approach.

By the same token, once a user publish a feed, we can also limit the fanout to only his active friends. For non-active users, most of the time the push operation is a waste since they will never come back consuming feeds.

Summary
If you follow 80-20 rule, 80% of the cost comes from 20% of features/users. As a result, optimization is really about identifying the bottleneck.

Also, feed system is a very popular topics since it’s widely used by so many products nowadays. If you are interested in this topic and want to explore more, I’d recommend you take a look at the following resources:

