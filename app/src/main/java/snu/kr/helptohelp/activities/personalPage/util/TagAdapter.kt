package snu.kr.helptohelp.activities.personalPage.util

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.card_tag.view.*
import snu.kr.helptohelp.R
import snu.kr.helptohelp.model.Tag

class TagAdapter(val tags: ArrayList<Tag>) : RecyclerView.Adapter<TagAdapter.ViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.card_tag, null))
    }

    override fun getItemCount() = tags.size

    override fun onBindViewHolder(viewHolder: ViewHolder, id: Int) {
        val tag = tags[id]
        viewHolder.view.tag_name.text = tag.content
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}