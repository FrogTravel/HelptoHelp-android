package snu.kr.helptohelp.activities.event

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_event.*
import snu.kr.helptohelp.R
import snu.kr.helptohelp.activities.glideUtil.GlideApp
import snu.kr.helptohelp.model.event.Event
import snu.kr.helptohelp.activities.userPage.UserPage
import snu.kr.helptohelp.activities.userPage.UserPageView
import snu.kr.helptohelp.model.User


class EventPageView : EventPage.View, AppCompatActivity() {
    lateinit var presenter: EventPage.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        presenter = EventPagePresenter(this)
        presenter.setEventId(intent.getIntExtra(EventPagePresenter.EVENT_ID, -1))


    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> this.finish()
        }
        return true
    }

    override fun showEvent(event: Event) {
        event_name.text = event.title
        event_description.text = event.description

        GlideApp.with(this)
                .load("http://www.organizedtransitionsllc.com/wp-content/uploads/2016/07/Food-Groceyr.jpg")//TODO hardcoded image
                .fitCenter()
                .into(cuisine_image)


        location.text = event.location

        val scale = this.resources.displayMetrics.density
        val pixels = (200 * scale + 0.5f).toInt()
        space_for_image.layoutParams.height = pixels
    }

    override fun showUser(user: User) {
        val scale = this.resources.displayMetrics.density

        val userImageSize = (100 * scale + 0.5f).toInt()

        GlideApp.with(this)
                .load(user.profile_pic)//TODO hardcoded image
                .override(userImageSize, userImageSize)
                .circleCrop()
                .into(user_image)

        user_name.text = user.name
    }

    override fun startUserPage(userId: Int) {
        val intent = Intent(this, UserPageView::class.java)
        intent.putExtra(UserPage.EXTRA_USER_ID, userId)
        startActivity(intent)
    }

    fun onUserCard(view: View){
        presenter.onUserCard()
    }


}