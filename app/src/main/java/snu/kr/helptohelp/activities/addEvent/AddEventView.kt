package snu.kr.helptohelp.activities.addEvent

import android.app.Activity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_create_event.*
import snu.kr.helptohelp.R

class AddEventView : AddEvent.View, Activity() {
    lateinit var presenter: AddEvent.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_event)
        presenter = AddEventPresenter(this)
    }

    fun onAddEvent(view: View){
        presenter.onAddEventClicked()
        finish()
    }

    override fun getEventTitle() = title_edit_text.text.toString()

    override fun getDescription() = description_edit_text.text.toString()
}