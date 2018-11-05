
package snu.kr.helptohelp.activities.profile

import android.content.Context
import snu.kr.helptohelp.model.User

interface UserProfile {
    interface View {
        fun getContext() : Context
        fun showUser(user: User)
        fun showEditMode()
        fun showProfileMode()
        fun getNewUserName() : String
        fun showUserEdit(user: User)
        fun getNewUserDescription(): String
    }

    interface Presenter {
        fun onModeChange()
        fun saveUser()
    }
}