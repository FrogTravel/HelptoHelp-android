package snu.kr.helptohelp.activities.userPage

import snu.kr.helptohelp.model.User

interface UserPage {
    companion object {
        val EXTRA_USER_ID = "user_id"
    }

    interface View {
        fun showUser(user: User)
    }

    interface Presenter {
        fun setUserId(id: Int)
    }
}