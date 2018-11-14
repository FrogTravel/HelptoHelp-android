package snu.kr.helptohelp.activities.registration

import snu.kr.helptohelp.model.APIPseudo

class RegistrationPresenter(val view: Registration.View) : Registration.Presenter {
    override fun onRegister() {
        checkData()
    }

    private fun checkData(){
        if(view.getFirstPassword() == view.getSecondPassword() && view.getLogin().isNotEmpty()){
            if(APIPseudo.register(view.getLogin(), view.getFirstPassword(), view.getName())){
                view.startMyEventsActivity()
            }
        }
    }
}