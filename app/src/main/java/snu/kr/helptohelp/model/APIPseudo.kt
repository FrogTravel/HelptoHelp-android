package snu.kr.helptohelp.model

import snu.kr.helptohelp.model.dummies.DummyObjects
import snu.kr.helptohelp.model.event.Event
import java.util.*

class APIPseudo {


    companion object {
//        val user1 = User(0, "Patrick G. Vazquez",  19,
//                "Able an hope of body. Any nay shyness article matters own removal nothing his forming",
//                profile_pic =ProfilePic( "https://steamcdn-a.akamaihd.net/steamcommunity/public/images/avatars/fa/fa84d1d5edc25f1f24a7a20010de5b12e5cdc6ec_full.jpg"),
//                isVerified = true, address = "NULL", futureEvents = arrayListOf(), pastEvents = arrayListOf(), reviews = arrayListOf())
//        val user2 = User(1, "Deann M. Tompkins",  20,
//                "Occasional entreaties comparison me difficulty so themselves",
//                profile_pic = ProfilePic("https://steamcdn-a.akamaihd.net/steamcommunity/public/images/avatars/4d/4d605658b016b5e843185cba8e156cd3c20685b3_full.jpg"),
//                isVerified = false, address = "NULL", futureEvents = arrayListOf(), pastEvents = arrayListOf(), reviews = arrayListOf())
//        val user3 = User(2, "Mildred R. Dake",  21,
//                "Living valley had silent eat merits esteem bed. In last an or went wise as left",
//                profile_pic = ProfilePic("https://steamcdn-a.akamaihd.net/steamcommunity/public/images/avatars/https://steamcdn-a.akamaihd.net/steamcommunity/public/images/avatars/9a/9a94ba902877ed15bd02b951ebd1802f85023c18_full.jpg"),
//                isVerified = true, address = "NULL", futureEvents = arrayListOf(), pastEvents = arrayListOf(), reviews = arrayListOf())
//        val user4 = User(3, "Stephen K. Howington", 42,
//                "At ourselves direction believing do he departure. Celebrated her had sentiments understood are projection set.",
//                profile_pic = ProfilePic("https://steamcdn-a.akamaihd.net/steamcommunity/public/images/avatars/00/00b085edb43dba0cc4dac65cd848c59817d3cb11_full.jpg"),
//                isVerified = true, address = "NULL", futureEvents = arrayListOf(), pastEvents = arrayListOf(), reviews = arrayListOf())
//        val user5 = User(4, "Chris J. Madore",  23,
//                "Little afraid its eat looked now. Very ye lady girl them good me make. It hardly cousin me always",
//                profile_pic = ProfilePic("https://steamcdn-a.akamaihd.net/steamcommunity/public/images/avatars/41/41c7afbf40255b7a6d4c3b5face8814d01c56231_full.jpg"),
//                isVerified = true, address = "NULL", futureEvents = arrayListOf(), pastEvents = arrayListOf(), reviews = arrayListOf())
//        val user6 = User(5, "Michael T. Meidinger", 53,
//                "You correct how sex several far distant believe journey parties. We shyness enquire uncivil affixed it carried to",
//                profile_pic = ProfilePic("https://steamcdn-a.akamaihd.net/steamcommunity/public/images/avatars/00/00b084a0c593fea10192f90b41467828b4018e50_full.jpg"),
//                isVerified = true, address = "NULL", futureEvents = arrayListOf(), pastEvents = arrayListOf(), reviews = arrayListOf())

//        val user1 = User(0, "Patrick G. Vazquez",  19,
//                "Able an hope of body. Any nay shyness article matters own removal nothing his forming",
//                profile_pic = "https://steamcdn-a.akamaihd.net/steamcommunity/public/images/avatars/fa/fa84d1d5edc25f1f24a7a20010de5b12e5cdc6ec_full.jpg",
//                isVerified = true, address = "NULL", futureEvents = arrayListOf(), pastEvents = arrayListOf(), reviews = arrayListOf())
//        val user2 = User(1, "Deann M. Tompkins",  20,
//                "Occasional entreaties comparison me difficulty so themselves",
//                profile_pic = "https://steamcdn-a.akamaihd.net/steamcommunity/public/images/avatars/4d/4d605658b016b5e843185cba8e156cd3c20685b3_full.jpg",
//                isVerified = false, address = "NULL", futureEvents = arrayListOf(), pastEvents = arrayListOf(), reviews = arrayListOf())
//        val user3 = User(2, "Mildred R. Dake",  21,
//                "Living valley had silent eat merits esteem bed. In last an or went wise as left",
//                profile_pic = "https://steamcdn-a.akamaihd.net/steamcommunity/public/images/avatars/https://steamcdn-a.akamaihd.net/steamcommunity/public/images/avatars/9a/9a94ba902877ed15bd02b951ebd1802f85023c18_full.jpg",
//                isVerified = true, address = "NULL", futureEvents = arrayListOf(), pastEvents = arrayListOf(), reviews = arrayListOf())
//        val user4 = User(3, "Stephen K. Howington", 42,
//                "At ourselves direction believing do he departure. Celebrated her had sentiments understood are projection set.",
//                profile_pic = "https://steamcdn-a.akamaihd.net/steamcommunity/public/images/avatars/00/00b085edb43dba0cc4dac65cd848c59817d3cb11_full.jpg",
//                isVerified = true, address = "NULL", futureEvents = arrayListOf(), pastEvents = arrayListOf(), reviews = arrayListOf())
//        val user5 = User(4, "Chris J. Madore",  23,
//                "Little afraid its eat looked now. Very ye lady girl them good me make. It hardly cousin me always",
//                profile_pic = "https://steamcdn-a.akamaihd.net/steamcommunity/public/images/avatars/41/41c7afbf40255b7a6d4c3b5face8814d01c56231_full.jpg",
//                isVerified = true, address = "NULL", futureEvents = arrayListOf(), pastEvents = arrayListOf(), reviews = arrayListOf())
//        val user6 = User(5, "Michael T. Meidinger", 53,
//                "You correct how sex several far distant believe journey parties. We shyness enquire uncivil affixed it carried to",
//                profile_pic = "https://steamcdn-a.akamaihd.net/steamcommunity/public/images/avatars/00/00b084a0c593fea10192f90b41467828b4018e50_full.jpg",
//                isVerified = true, address = "NULL", futureEvents = arrayListOf(), pastEvents = arrayListOf(), reviews = arrayListOf())


        val user1 = DummyObjects.getDummyUser()
        val user2 = DummyObjects.getDummyUser()
        val user3 = DummyObjects.getDummyUser()
        val user4 = DummyObjects.getDummyUser()
        val user5 = DummyObjects.getDummyUser()
        val user6 = DummyObjects.getDummyUser()

        val userList = listOf(user1, user2, user3, user4, user5, user6)

        val review1 = Review("As so we smart those money in. Am wrote up whole so tears sense oh. Absolute required of reserved in offering no. ", "user1", "",5)
        val review2 = Review("How remainder all additions get elsewhere resources. One missed shy wishes supply design answer formed.", "uessr2", "",5)

        val futureEvent1 = DummyObjects.getDummyEvent()
        val futureEvent2 = DummyObjects.getDummyEvent()

        val pastEvent1 = DummyObjects.getDummyEvent()
        val pastEvent2 = DummyObjects.getDummyEvent()

        val eventList = arrayListOf<Event>()



        fun getUsers(searchQuery: SearchQuery): List<User> = userList

        fun getUser(id: Int) = userList[id]

        fun getFutureEventsForUsers(id: Int) = eventList

        fun getPastEventsForUsers(id: Int) = listOf(pastEvent1, pastEvent2)

        fun getEvent(id: Int) = futureEvent1

        fun getCurrentUser() = user1

        fun addEvent(event: Event) {
            eventList.add(event)
        }

        fun searchEvent(searchQuery: SearchQuery) = getPastEventsForUsers(0)

        fun isRegistered(login: String) = true

        fun isRightPassword(login: String, password: String) = true

        fun register(login: String, firstPassword: String, name: String) = true
    }
}