package snu.kr.helptohelp.activities.search.util

import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.user_search_card.view.*
import snu.kr.helptohelp.R
import snu.kr.helptohelp.activities.glideUtil.GlideApp
import snu.kr.helptohelp.activities.search.SearchResultView
import snu.kr.helptohelp.activities.userPage.UserPageView
import snu.kr.helptohelp.model.User

class SearchResultAdapter(val users: List<User>) : RecyclerView.Adapter<SearchResultAdapter.ViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.user_search_card, null))
    }

    override fun getItemCount() = users.size


    override fun onBindViewHolder(viewHolder: ViewHolder, id: Int) {
        val user = users[id]

        val intent =  Intent(viewHolder.view.context, UserPageView::class.java)
        intent.putExtra(SearchResultView.EXtRA_USER_ID, user.id)
        viewHolder.view.setOnClickListener { startActivity(viewHolder.view.context, intent, null) }

        viewHolder.view.user_name.text = user.name
        GlideApp.with(viewHolder.view)
                .load(user.imageURL)
                .placeholder(R.drawable.ic_search)
                .into(viewHolder.view.user_image)
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}
