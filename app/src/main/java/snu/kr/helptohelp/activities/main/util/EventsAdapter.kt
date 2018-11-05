package snu.kr.helptohelp.activities.main.util

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.event_card.view.*
import snu.kr.helptohelp.R
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
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}