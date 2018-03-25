1.Data Model:
  我们需要三个表：
  a. friend-friend Table:
    |userID|uSerID|
  b. user-feed Table:
    |userID|feedID|
  c. feedContent Table:(Optional)
     |feedID|feedContent|
	The system will first get all userIDs of friends from friend table. 
Then it fetches all feedIDs for each friend from user-feed table. 
Finally, feed content is fetched based on feedID from feed table. 
You can see that we need to perform 3 joins, which can affect performance.
	A common optimization is to store feed content together with feedID 
in user-feed table so that we don’t need to join the feed table any more. 
This approach is called denormalization, which means by adding redundant data, 
we can optimize the read performance (reducing the number of joins).

The disadvantages are obvious:
	Data redundancy. We are storing redundant data, which occupies storage space 
(classic time-space trade-off).
Data consistency. Whenever we update a feed, we need to update both feed table 
and user-feed table. Otherwise, there is data inconsistency. This increases the complexity of the system.
	Remember that there’s no one approach always better than the other 
(normalization vs denormalization). It’s a matter of whether you want to optimize 
for read or write.
2.Ranking
	The most straightforward way to rank feeds is by the time it was created. 
Obviously, Facebook is doing more than that. “Important” feeds are ranked on top.
	Before jumping to the ranking algorithm, I’d usually like to ask why do we want to
change the ranking? How do we evaluate whether the new ranking algorithm is better? 
It’s definitely impressive if candidates come up with these questions by themselves.
	The reason to have better ranking is not that this seems the right thing to do. 
Instead, everything should happen for a reason. Let’s say there are several core 
metrics we care about, e.g. users stickiness, retention, ads revenue etc.. 
	A better ranking system can significantly improve these metrics potentially, which 
also answers how to evaluate if we are making progress.
	So back to the question – how should we rank feeds? A common strategy is to 
calculate a feed score based on various features and rank feeds by its score, 
which is one of the most common approaches for all ranking problems.
	More specifically, we can select several features that are mostly relevant to the
importance of the feed, e.g. share/like/comments numbers, time of the update, 
whether the feed has images/videos etc.. 
And then, a score can be computed by these features, maybe a linear combination. 
This is usually enough for a naive ranking system.
	Just briefly summarize what we have discussed in part 1. We started with a simple 
question – how to design news feed system for Facebook that allows users see feeds
updates from friends. We modeled the whole system using relational database and talked about pros and cons of different design.
	Ranking is an interesting topic for news feed system. We explained some general
ideas of ranking in previous post. And in this post, we’ll continue the discussion
ranking and also cover topics like feed publishing and so on.
	The general idea of ranking is to first select features/signals that are relevant
and then figure out how to combine them to calculate a final score. This approach is extremely common among lots of real-world systems.
	As you can see that what matters here are two things – features and calculation
algorithm. To give you a better idea of it, I’d like to briefly introduce how ranking actually works at Facebook – EdgeRank.
	For each news update you have, whenever another user interacts with that feed,
they’re creating what Facebook calls an Edge, which includes actions like like and comments.
	First of all, let’s take a look at what features are used to evaluate the importance
of an update/feed. Edge Rank basically is using three signals: affinity score, edge weight and time decay.
	Affinity score (u). For each news feed, affinity score evaluates how close you are
with this user. For instance, you are more likely to care about feed from your close friends instead of someone you just met once. You might ask how affinity score is calculated, I’ll talk about it soon.
	Edge weight (e). Edge weight basically reflects importance of each edge. For
instance, comments are worth more than likes.
	Time decay (d). The older the story, the less likely users find it interesting.
	So how does Facebook rank feeds by these three features? The calculation algorithm
is quite straightforward. For each feed you create, multiply these factors for each Edge then add the Edge scores up and you have an update’s EdgeRank. And the higher that is, the more likely your update is to appear in the user’s feed.
	Affinity score
	We can do exactly the same thing to evaluate affinity score.Various factors can be
used to reflect how close two people are. First of all, explicit interactions like comment, like, tag, share, click etc. are strong signals we should use. Apparently, each type of interaction should have different weight. For instance, comments should be worth much more than likes.
	Secondly, we should also track the time factor. Perhaps you used to interact with a
friend quite a lot, but less frequent recently. In this case, we should lower the affinity score. So for each interaction, we should also put the time decay factor.
	To sum up the ranking section, I hope this common approach for ranking can be one of
your takeaways. Also, EdgeRank was first published at 2010 and it can be outdated.
3.Feed publishing
	When a user loads all the feeds from his friends, it can be an extremely costly
action. Remember that a user can have thousands of friends and each of them can publish a huge amount of updates especially for high profile users. To load all feeds from friends, the system requires at least two joins (get friends list and feed list.
	So how to optimize and scale the feed publishing system?
	Basically there are two common approaches here – push and pull.
	For a push system, once a user has published a feed, we immediately pushing this
feed (actually the pointer to the feed) to all his friends. The advantage is that when fetching feed, you don’t need to go through your friends list and get feeds for each of them. It significantly reduces read operation. However, the downside is also obvious. 
It increases write operation especially for people with a large number of friends.
	For a pull system, feeds are only fetched when users are loading their home pages.
So feed data doesn’t need to be sent right after it’s created. You can see that this approach optimizes for write operation, but can be quite slow to fetch data even after using denormalization (check our previous post if you don’t understand this).
	Both approaches work well at certain circumstances and it’s always better to
understand their pros and cons.

