package snu.kr.helptohelp.model

class API{
    companion object {
        val user1 = User(1, "Name1", "somenickname1", 19, "some desk", isVerified = true)
        val user2 = User(2, "Name2", "somenickname2", 20, "some desk", isVerified = false)
        val user3 = User(3, "Name3", "somenickname3", 21, "some desk", isVerified = true)

        val history1 = History("his 1", 5)
        val history2 = History("his 2", 2)

        val review1 = Review("review1", user1, 5)
        val review2 = Review("review2", user2, 5)

        val futureEvent1 = Event(0, user1, "future event1", "desc Event1", "Seoul")
        val futureEvent2 = Event(1, user1, "future event2", "desc Event2", "Seoul")

        val pastEvent1 = Event(2, user1, "past event1", "desc Event1", "Seoul")
        val pastEvent2 = Event(3, user1, "past event2", "desc Event2", "Seoul")

        val eventList = arrayListOf<Event>()

        fun getUserProfileData(searchQuery: SearchQuery) : List<UserProfileData> =  listOf(UserProfileData(user1,
                    reviews = listOf(review1),
                    history = listOf(history1, history1)),
                UserProfileData(user1,
                        reviews = listOf(review1, review1),
                        history = listOf(history1, history1)))


        fun getUsers(searchQuery: SearchQuery) : List<User> = listOf(user1, user1)

        fun getUser(id: Int) = User(id, "SOME_NAME_FOR_THAT_USER", "somenickname", 19, "some desk", isVerified = true)

        fun getUserProfileData(id: Int) = UserProfileData(user1,
                reviews = listOf(review1, review1),
                history = listOf(history1, history1))

        fun getFutureEventsForUsers(id: Int) = eventList

        fun getPastEventsForUsers(id: Int) = listOf(pastEvent1, pastEvent2)

        fun getEvent(id: Int) = futureEvent1

        fun getCurrentUser() = user1

        fun addEvent(event: Event){
            eventList.add(event)
        }
    }
}