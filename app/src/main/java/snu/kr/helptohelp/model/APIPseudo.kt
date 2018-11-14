package snu.kr.helptohelp.model

import java.util.*

class APIPseudo {


    companion object {
        val user1 = User(0, "Patrick G. Vazquez", "Aboul1964", 19,
                "Able an hope of body. Any nay shyness article matters own removal nothing his forming",
                imageURL = "https://steamcdn-a.akamaihd.net/steamcommunity/public/images/avatars/fa/fa84d1d5edc25f1f24a7a20010de5b12e5cdc6ec_full.jpg",
                isVerified = true)
        val user2 = User(1, "Deann M. Tompkins", "Alks1994", 20,
                "Occasional entreaties comparison me difficulty so themselves",
                imageURL = "https://steamcdn-a.akamaihd.net/steamcommunity/public/images/avatars/4d/4d605658b016b5e843185cba8e156cd3c20685b3_full.jpg",
                isVerified = false)
        val user3 = User(2, "Mildred R. Dake", "Experwas", 21,
                "Living valley had silent eat merits esteem bed. In last an or went wise as left",
                imageURL = "https://steamcdn-a.akamaihd.net/steamcommunity/public/images/avatars/https://steamcdn-a.akamaihd.net/steamcommunity/public/images/avatars/9a/9a94ba902877ed15bd02b951ebd1802f85023c18_full.jpg",
                isVerified = true)
        val user4 = User(3, "Stephen K. Howington", "Anithfultans", 42,
                "At ourselves direction believing do he departure. Celebrated her had sentiments understood are projection set.",
                imageURL = "https://steamcdn-a.akamaihd.net/steamcommunity/public/images/avatars/00/00b085edb43dba0cc4dac65cd848c59817d3cb11_full.jpg",
                isVerified = true)
        val user5 = User(4, "Chris J. Madore", "Thood1970", 23,
                "Little afraid its eat looked now. Very ye lady girl them good me make. It hardly cousin me always",
                imageURL = "https://steamcdn-a.akamaihd.net/steamcommunity/public/images/avatars/41/41c7afbf40255b7a6d4c3b5face8814d01c56231_full.jpg",
                isVerified = true)
        val user6 = User(5, "Michael T. Meidinger", "Wils1998", 53,
                "You correct how sex several far distant believe journey parties. We shyness enquire uncivil affixed it carried to",
                imageURL = "https://steamcdn-a.akamaihd.net/steamcommunity/public/images/avatars/00/00b084a0c593fea10192f90b41467828b4018e50_full.jpg",
                isVerified = true)

        val userList = listOf(user1, user2, user3, user4, user5, user6)

        val review1 = Review("As so we smart those money in. Am wrote up whole so tears sense oh. Absolute required of reserved in offering no. ", user1, 5)
        val review2 = Review("How remainder all additions get elsewhere resources. One missed shy wishes supply design answer formed.", user2, 5)

        val futureEvent1 = Event(0, user1, "Korean", "Whole every miles as tiled at seven or. Wished he entire esteem mr oh by. Possible bed you pleasure civility boy elegance ham. Whole every miles as tiled at seven or. Wished he entire esteem mr oh by. Possible bed you pleasure civility boy elegance ham Whole every miles as tiled at seven or. Wished he entire esteem mr oh by. Possible bed you pleasure civility boy elegance ham Whole every miles as tiled at seven or. Wished he entire esteem mr oh by. Possible bed you pleasure civility boy elegance ham Whole every miles as tiled at seven or. Wished he entire esteem mr oh by. Possible bed you pleasure civility boy elegance ham Whole every miles as tiled at seven or. Wished he entire esteem mr oh by. Possible bed you pleasure civility boy elegance ham Whole every miles as tiled at seven or. Wished he entire esteem mr oh by. Possible bed you pleasure civility boy elegance ham Whole every miles as tiled at seven or. Wished he entire esteem mr oh by. Possible bed you pleasure civility boy elegance ham Whole every miles as tiled at seven or. Wished he entire esteem mr oh by. Possible bed you pleasure civility boy elegance ham Whole every miles as tiled at seven or. Wished he entire esteem mr oh by. Possible bed you pleasure civility boy elegance ham Whole every miles as tiled at seven or. Wished he entire esteem mr oh by. Possible bed you pleasure civility boy elegance ham Whole every miles as tiled at seven or. Wished he entire esteem mr oh by. Possible bed you pleasure civility boy elegance ham Whole every miles as tiled at seven or. Wished he entire esteem mr oh by. Possible bed you pleasure civility boy elegance ham", "Seoul")
        val futureEvent2 = Event(1, user1, "Hyderabad", "Valley afford uneasy joy she thrown though bed set. In me forming general prudent on country carried", "Seoul")

        val pastEvent1 = Event(2, user1, "Romanian", "Impossible considered invitation him men instrument saw celebrated unpleasant. Put rest and must set kind next many near nay.", "Seoul")
        val pastEvent2 = Event(3, user1, "Slovenian", "Hardly suffer wisdom wishes valley as an. As friendship advantages resolution it alteration stimulated he or increasing.", "Seoul")

        val eventList = arrayListOf<Event>()

        fun getUserProfileData(searchQuery: SearchQuery): List<UserProfileData> =
                listOf(UserProfileData(userList[Random().nextInt(userList.size)],
                        reviews = listOf(review1),
                        history = listOf(futureEvent1, futureEvent2)),
                        UserProfileData(userList[Random().nextInt(userList.size)],
                                reviews = listOf(review1, review2),
                                history = listOf(futureEvent1, futureEvent1)))


        fun getUsers(searchQuery: SearchQuery): List<User> = userList

        fun getUser(id: Int) = userList[id]

        fun getUserProfileData(id: Int) = UserProfileData(getUser(id),
                reviews = listOf(review1, review2),
                history = listOf(futureEvent1, futureEvent2))

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