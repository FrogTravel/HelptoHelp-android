package snu.kr.helptohelp.activities.userPage

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_user.*
import snu.kr.helptohelp.R
import snu.kr.helptohelp.activities.glideUtil.GlideApp
import snu.kr.helptohelp.activities.userPage.fragments.FragmentHistory
import snu.kr.helptohelp.activities.userPage.fragments.FragmentReviews
import snu.kr.helptohelp.activities.userPage.fragments.FragmentUser
import snu.kr.helptohelp.activities.userPage.util.ViewPagerAdapter
import snu.kr.helptohelp.model.UserProfileData

class UserPageView : UserPage.View, AppCompatActivity() {
    lateinit var presenter: UserPage.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        presenter = UserPagePresenter(this)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        presenter.setUserId(intent.getIntExtra(UserPage.EXTRA_USER_ID, -1))
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
                .into(user_image)
        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)

        val fragmentUser = FragmentUser()
        val userArgs = Bundle()
        //TODO Может можно переделать user в Serializable, но я боюсь из-за retrofit. Потом проверить!
        userArgs.putSerializable(FragmentUser.USER_NAME, userProfileData.user.name)
        userArgs.putSerializable(FragmentUser.USER_DESC, userProfileData.user.description)
        fragmentUser.arguments = userArgs
        viewPagerAdapter.addFragment(fragmentUser, "Overview")

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