package snu.kr.helptohelp.activities.userPage

import android.app.Activity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_user.*
import snu.kr.helptohelp.R
import snu.kr.helptohelp.activities.glideUtil.GlideApp
import snu.kr.helptohelp.activities.search.SearchResultView
import snu.kr.helptohelp.activities.userPage.fragments.FragmentHistory
import snu.kr.helptohelp.activities.userPage.fragments.FragmentReviews
import snu.kr.helptohelp.activities.userPage.fragments.HistoryList
import snu.kr.helptohelp.activities.userPage.fragments.ReviewList
import snu.kr.helptohelp.activities.userPage.util.UserReviewsAdapter
import snu.kr.helptohelp.activities.userPage.util.ViewPagerAdapter
import snu.kr.helptohelp.model.User

class UserPageView : UserPage.View, AppCompatActivity() {
    lateinit var presenter: UserPage.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        presenter = UserPagePresenter(this)


        presenter.setUserId(intent.getIntExtra(SearchResultView.EXtRA_USER_ID, -1))


    }

    override fun showUser(user: User) {
        GlideApp.with(this)
                .load(user.imageURL)
                .placeholder(R.drawable.ic_search)
                .into(user_image)

        user_name.text = user.name

        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)

        val fragmentReviews = FragmentReviews()
        val reviewArgs = Bundle()
        reviewArgs.putSerializable(FragmentReviews.REVIEW_LIST, ReviewList(user.reviews))
        fragmentReviews.arguments = reviewArgs
        viewPagerAdapter.addFragment(fragmentReviews, "Reviews")

        val fragmentHistory = FragmentHistory()
        val historyArgs = Bundle()
        historyArgs.putSerializable(FragmentHistory.HISTORY_ARG, HistoryList(user.history))
        fragmentHistory.arguments = historyArgs
        viewPagerAdapter.addFragment(fragmentHistory, "History")
        view_pager.adapter = viewPagerAdapter
    }

}