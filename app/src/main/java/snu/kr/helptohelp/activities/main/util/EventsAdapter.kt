package snu.kr.helptohelp.activities.main.util

import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.event_card.view.*
import snu.kr.helptohelp.R
import snu.kr.helptohelp.activities.event.EventPagePresenter
import snu.kr.helptohelp.activities.event.EventPageView
import snu.kr.helptohelp.model.Event

class EventsAdapter(val events: List<Event>) : RecyclerView.Adapter<EventsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.event_card, null))
    }

    override fun getItemCount() = events.size

    override fun onBindViewHolder(viewHolder: ViewHolder, id: Int) {
        val event = events[id]
        viewHolder.view.event_name.text = event.title
        viewHolder.view.event_description.text = event.description
        viewHolder.view.address_text_view.text = event.location

        val intent = Intent(viewHolder.view.context, EventPageView::class.java)
        intent.putExtra(EventPagePresenter.EVENT_ID, event.id)
        viewHolder.view.setOnClickListener { startActivity(viewHolder.view.context, intent, null) }
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}