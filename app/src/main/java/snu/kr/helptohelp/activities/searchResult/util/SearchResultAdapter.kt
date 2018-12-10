package snu.kr.helptohelp.activities.searchResult.util

import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_profile.view.*
import kotlinx.android.synthetic.main.card_event.view.*
import snu.kr.helptohelp.R
import snu.kr.helptohelp.activities.event.EventPage
import snu.kr.helptohelp.activities.event.EventPageView
import snu.kr.helptohelp.activities.userPage.UserPage
import snu.kr.helptohelp.activities.userPage.UserPageView
import snu.kr.helptohelp.model.UserMatch
import snu.kr.helptohelp.model.event.Event

class SearchResultAdapter(val users: ArrayList<UserMatch>) : RecyclerView.Adapter<SearchResultAdapter.ViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.card_event, null))
    }

    override fun getItemCount() = users.size


    override fun onBindViewHolder(viewHolder: ViewHolder, id: Int) {
        val user = users[id]

        val intent = Intent(viewHolder.view.context, UserPageView::class.java)
        intent.putExtra(UserPage.EXTRA_USER_ID, user.id)
        viewHolder.view.setOnClickListener { startActivity(viewHolder.view.context, intent, null) }

        viewHolder.view.event_name.text = user.name
//
//        viewHolder.view.user_name.text = event.hostUser.name
//        GlideApp.with(viewHolder.view.context)
//                .load(event.hostUser.profile_pic)
//                .transform(CircleCrop())
//                .override(100, 100)
//                .into(viewHolder.view.user_image)

        viewHolder.view.event_description.text = user.description
        viewHolder.view.address_text_view.text = user.address

    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}
