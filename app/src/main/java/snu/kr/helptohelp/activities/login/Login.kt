package snu.kr.helptohelp.activities.login

import android.content.Context

interface Login {
    interface View {
        fun getContext() : Context
        fun getPassword() : String
        fun getLogin() : String
        fun showNotRegisteredError()
        fun showLoginError()
        fun startMyEventsActivity()
    }

    interface Presenter {
        fun onLoginButton()
    }
}