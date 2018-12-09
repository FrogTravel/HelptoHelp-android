package snu.kr.helptohelp.activities.addEvent

import snu.kr.helptohelp.model.APIPseudo
import snu.kr.helptohelp.model.dummies.DummyObjects
import snu.kr.helptohelp.model.event.Event

class AddEventPresenter(val view: AddEvent.View) : AddEvent.Presenter{
    override fun onAddEventClicked() {
        APIPseudo.addEvent(getEventFromView())
    }
    //TODO change to get current name
    fun getEventFromView() = DummyObjects.getDummyEvent()

}