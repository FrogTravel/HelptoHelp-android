package snu.kr.helptohelp.activities.searchResult.util

import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import kotlinx.android.synthetic.main.card_event.view.*
import snu.kr.helptohelp.R
import snu.kr.helptohelp.activities.event.EventPage
import snu.kr.helptohelp.activities.event.EventPageView
import snu.kr.helptohelp.activities.glideUtil.GlideApp
import snu.kr.helptohelp.model.Event

class SearchResultAdapter(val events: List<Event>) : RecyclerView.Adapter<SearchResultAdapter.ViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.card_event, null))
    }

    override fun getItemCount() = events.size


    override fun onBindViewHolder(viewHolder: ViewHolder, id: Int) {
        val event = events[id]

        val intent = Intent(viewHolder.view.context, EventPageView::class.java)
        intent.putExtra(EventPage.EVENT_ID, event.id)
        viewHolder.view.setOnClickListener { startActivity(viewHolder.view.context, intent, null) }

        viewHolder.view.event_name.text = event.title

        viewHolder.view.user_name.text = event.hostUser.name
        GlideApp.with(viewHolder.view.context)
                .load(event.hostUser.profile_pic_url)
                .transform(CircleCrop())
                .override(100, 100)
                .into(viewHolder.view.user_image)

        viewHolder.view.event_description.text = event.description
        viewHolder.view.address_text_view.text = event.location

    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}
