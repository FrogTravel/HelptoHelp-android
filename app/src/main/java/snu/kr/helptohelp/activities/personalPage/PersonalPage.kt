
package snu.kr.helptohelp.activities.personalPage

import android.content.Context
import snu.kr.helptohelp.model.Tag
import snu.kr.helptohelp.model.User

interface PersonalPage {
    interface View {
        fun getContext() : Context
        fun showUser(user: User)
        fun showEditMode()
        fun showProfileMode()
        fun getNewUserName() : String
        fun showUserEdit(user: User)
        fun getNewUserDescription(): String
        fun showTags(tags: ArrayList<Tag>)
        fun getNewAge() : Int
        fun getNewLanguage() : String
        fun getNewAddress() : String
    }

    interface Presenter {
        fun onModeChange()
        fun saveUser()
    }
}