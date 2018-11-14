package snu.kr.helptohelp.activities.addEvent

import snu.kr.helptohelp.model.APIPseudo
import snu.kr.helptohelp.model.Event

class AddEventPresenter(val view: AddEvent.View) : AddEvent.Presenter{
    override fun onAddEventClicked() {
        APIPseudo.addEvent(getEventFromView())
    }

    fun getEventFromView() = Event(hostUser = APIPseudo.getCurrentUser(),title =  view.getEventTitle(),
            description = view.getDescription(), location =  "Seoul")

}