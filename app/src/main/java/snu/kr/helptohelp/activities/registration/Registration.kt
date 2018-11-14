package snu.kr.helptohelp.activities.registration

interface Registration {
    interface View {
        fun getFirstPassword(): String
        fun getSecondPassword(): String
        fun getLogin(): String
        fun getName(): String
        fun startMyEventsActivity()
    }

    interface Presenter {
        fun onRegister()
    }
}