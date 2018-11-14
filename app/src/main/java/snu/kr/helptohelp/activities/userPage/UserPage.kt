package snu.kr.helptohelp.activities.userPage

import snu.kr.helptohelp.model.User
import snu.kr.helptohelp.model.UserProfileData

interface UserPage {
    companion object {
        val EXTRA_USER_ID = "user_id"
    }

    interface View {
        fun showUser(userProfileData: UserProfileData)
    }

    interface Presenter {
        fun setUserId(id: Int)
    }
}