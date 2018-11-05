package snu.kr.helptohelp.activities.userPage

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.MenuItem
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import kotlinx.android.synthetic.main.activity_user.*
import snu.kr.helptohelp.R
import snu.kr.helptohelp.activities.glideUtil.GlideApp
import snu.kr.helptohelp.activities.search.SearchResultView
import snu.kr.helptohelp.activities.userPage.fragments.FragmentHistory
import snu.kr.helptohelp.activities.userPage.fragments.FragmentReviews
import snu.kr.helptohelp.activities.userPage.util.ViewPagerAdapter
import snu.kr.helptohelp.model.User
import snu.kr.helptohelp.model.UserProfileData

class UserPageView : UserPage.View, AppCompatActivity() {
    lateinit var presenter: UserPage.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        presenter = UserPagePresenter(this)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        presenter.setUserId(intent.getIntExtra(SearchResultView.EXTRA_USER_ID, -1))
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> this.finish()
        }
        return true
    }

    override fun showUser(userProfileData: UserProfileData) {
        GlideApp.with(this)
                .load(userProfileData.user.imageURL)
                .transform(CircleCrop())
                .override(400, 400)
                .into(user_image)

        user_name.text = userProfileData.user.name
        description_text_view.text = userProfileData.user.description

        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)

        val fragmentReviews = FragmentReviews()
        val reviewArgs = Bundle()
        reviewArgs.putSerializable(FragmentReviews.REVIEW_LIST, FragmentReviews.ReviewList(userProfileData.reviews))
        fragmentReviews.arguments = reviewArgs
        viewPagerAdapter.addFragment(fragmentReviews, "Reviews")

        val fragmentHistory = FragmentHistory()
        val historyArgs = Bundle()
        historyArgs.putSerializable(FragmentHistory.HISTORY_ARG, FragmentHistory.HistoryList(userProfileData.history))
        fragmentHistory.arguments = historyArgs
        viewPagerAdapter.addFragment(fragmentHistory, "History")
        view_pager.adapter = viewPagerAdapter
    }

}