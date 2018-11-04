package snu.kr.helptohelp.activities.userPage.util

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.review_card.view.*
import snu.kr.helptohelp.R
import snu.kr.helptohelp.model.Review

class UserReviewsAdapter(val reviews: List<Review>) : RecyclerView.Adapter<UserReviewsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.review_card, null))
    }

    override fun getItemCount() = reviews.size

    override fun onBindViewHolder(viewHolder: ViewHolder, id: Int) {
        val review = reviews[id]
        viewHolder.view.review_text_view.text = review.reviewText
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}