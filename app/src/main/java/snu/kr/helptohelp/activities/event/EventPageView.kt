package snu.kr.helptohelp.activities.event

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_event.*
import snu.kr.helptohelp.R
import snu.kr.helptohelp.model.Event

class EventPageView : EventPage.View, AppCompatActivity() {
    lateinit var presenter : EventPage.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        presenter = EventPagePresenter(this)
        presenter.setEventId(intent.getIntExtra(EventPagePresenter.EVENT_ID, -1))
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            android.R.id.home -> this.finish()
        }
        return true
    }

    override fun showEvent(event: Event) {
        event_name.text = event.title
        event_description.text = event.description
    }
}