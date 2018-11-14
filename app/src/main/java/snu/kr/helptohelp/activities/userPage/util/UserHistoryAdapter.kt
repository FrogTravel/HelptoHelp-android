package snu.kr.helptohelp.activities.userPage.util

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.card_history.view.*
import snu.kr.helptohelp.R
import snu.kr.helptohelp.model.Event

class UserHistoryAdapter(val histories: List<Event>) : RecyclerView.Adapter<UserHistoryAdapter.ViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.card_history, null))
    }

    override fun getItemCount() = histories.count()

    override fun onBindViewHolder(viewHolder: ViewHolder, id: Int){
        viewHolder.view.name_text_view.text = histories[id].title
        viewHolder.view.description_text_view.text = histories[id].description
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}