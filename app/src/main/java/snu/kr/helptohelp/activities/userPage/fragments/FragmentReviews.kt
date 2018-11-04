package snu.kr.helptohelp.activities.userPage.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_reviews.*
import kotlinx.android.synthetic.main.fragment_reviews.view.*
import snu.kr.helptohelp.R
import snu.kr.helptohelp.activities.userPage.util.UserReviewsAdapter
import snu.kr.helptohelp.model.Review
import java.io.Serializable

class FragmentReviews : Fragment() {
    companion object {
        val REVIEW_LIST = "reviewList"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_reviews, container, false)


        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        review_recycler_view.adapter = UserReviewsAdapter((arguments?.getSerializable(REVIEW_LIST) as ReviewList).reviewList)
        review_recycler_view.layoutManager = LinearLayoutManager(this.context)

    }
}

data class ReviewList(val reviewList: List<Review>) : Serializable