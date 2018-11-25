package snu.kr.helptohelp.activities.userPage.util

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import kotlinx.android.synthetic.main.card_review.view.*
import snu.kr.helptohelp.R
import snu.kr.helptohelp.activities.glideUtil.GlideApp
import snu.kr.helptohelp.model.Review

class UserReviewsAdapter(val reviews: List<Review>) : RecyclerView.Adapter<UserReviewsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.card_review, null))
    }

    override fun getItemCount() = reviews.size

    override fun onBindViewHolder(viewHolder: ViewHolder, id: Int) {
        val review = reviews[id]
        viewHolder.view.user_name.text = review.user.name
        viewHolder.view.review_text_view.text = review.reviewText

        GlideApp.with(viewHolder.view)
                .load(review.user.profile_pic_url)
                .transform( CircleCrop())
                .override(100,100)
                .into(viewHolder.view.user_image)
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}