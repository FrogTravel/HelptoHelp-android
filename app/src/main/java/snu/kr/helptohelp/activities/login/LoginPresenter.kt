package snu.kr.helptohelp.activities.login

import snu.kr.helptohelp.model.APIPseudo

class LoginPresenter(val view: Login.View) : Login.Presenter{

    override fun onLoginButton() {
        if(APIPseudo.isRegistered(view.getLogin())){
            if(APIPseudo.isRightPassword(view.getLogin(), view.getPassword())){
                view.startMyEventsActivity()
            }else{
                view.showNotRegisteredError()
            }
        }else{
            view.showLoginError()
        }

    }


}