package snu.kr.helptohelp.activities.userPage

import snu.kr.helptohelp.model.User

interface UserPage {
    interface View {
        fun showUser(user: User)
    }

    interface Presenter {
        fun setUserId(id: Int)
    }
}