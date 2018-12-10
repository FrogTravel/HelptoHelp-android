package snu.kr.helptohelp.model.dummies

import snu.kr.helptohelp.model.ProfilePic
import snu.kr.helptohelp.model.User
import snu.kr.helptohelp.model.event.Event

class DummyObjects{
    companion object {
//        fun getDummyUser() = User(-1, "NULL", -1, "NULL", ProfilePic("URL"), false, "NULL", arrayListOf(), arrayListOf(), arrayListOf())
        fun getDummyUser() = User(-1, "NULL", -1, "NULL", 0, "URL", "", arrayListOf(),"",false, "NULL", arrayListOf(), arrayListOf(), arrayListOf())

        fun getDummyEvent() = Event(-1, getDummyUser(), "NULL", "NULL", "NULL", "", "",false)
    }
}