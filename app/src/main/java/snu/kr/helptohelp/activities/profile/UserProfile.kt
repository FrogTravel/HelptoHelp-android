
package snu.kr.helptohelp.activities.profile

import android.content.Context
import snu.kr.helptohelp.model.User

interface UserProfile {
    interface View {
        fun getContext() : Context
        fun showUser(user: User)
    }

    interface Presenter {

    }
}