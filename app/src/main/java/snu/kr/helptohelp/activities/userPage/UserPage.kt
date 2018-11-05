package snu.kr.helptohelp.activities.userPage

import snu.kr.helptohelp.model.User
import snu.kr.helptohelp.model.UserProfileData

interface UserPage {
    interface View {
        fun showUser(userProfileData: UserProfileData)
    }

    interface Presenter {
        fun setUserId(id: Int)
    }
}