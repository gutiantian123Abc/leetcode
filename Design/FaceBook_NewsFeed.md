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

