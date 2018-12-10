package snu.kr.helptohelp.activities.userPage.util

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.card_food_type.view.*
import snu.kr.helptohelp.R
import snu.kr.helptohelp.model.HostTag

class FoodTypeRecyclerView(val food_types: ArrayList<HostTag>) : RecyclerView.Adapter<FoodTypeRecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.card_food_type, null))
    }

    override fun getItemCount() = food_types.size

    override fun onBindViewHolder(viewHolder: ViewHolder, id: Int) {
        viewHolder.view.textView.text = food_types[id].tag + " "
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}