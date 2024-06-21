<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 400px; margin: 20px; word-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Topic: Design a hotel system + RestAPI

Solution:

	Resources:
	   Room
	        Guid id
	        RoomType type
	        Status status
	        Double price
	   Booking
	        Guid id
	        Room[] rooms
	        DateTime startDate
	        DateTime endDate
	   Customer
	        Guid id
	        String Fristname
	        String LastName
	        String middleName
	        String address
	        Booking booking
	   RoomType
	        Single
	        Double
	        Deluxe
	        Presidential
	   Status
	        Occupied   -- 0
	        UnOccupied -- 1



	Operations

	Room
	    get -- /rooms/{id}
	    put -- /rooms/{id} (body- RoomType type) -- update a room like updating room type
	    post -- /rooms (body - Room room) -- create a new room.
	    delete -- /rooms/{id} -- remove a room from the system.

	sub-resource queries --
	 1. Give me all rooms which are un-occupied
	    get -- /rooms/status/1 
	    //or use filtering
	    get -- /rooms?status=1
	 2. Give me all Deluxe rooms that are Occupied
	    get -- rooms/roomType/2/status/0



	Booking
	    get -- /bookings/{id} -- retrieve a booking given an Id
	    put -- /bookings/{id} (body -- booking) -- update a booking given a booking Id
	    post -- /bookings (body -- booking) -- create a new booking
	    delete -- /bookings/{Id} -- remove a booking given a booking id

	//Filtering
	Give me all bookings for Presidential suites between Jul 1 to Jul 5
	get -- /bookings/roomType/3?start>=startDate&end<=endDate

	on top of this you could provide fields, paging, sorting and so on
	fields -- For mobile clients, they dont need all the attributes of your resource, 
	so you can specify in the URI, which fields you want to return. (This could reduce the bandwidth)

	/customers/{id}?fields=firstname,lastname

	paging allows your to limit the amount of data returned for the request
	/bookings?offset=5&limit=50
*/</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>
</code></pre>
</div>
</div>
