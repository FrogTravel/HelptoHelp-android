package snu.kr.helptohelp.activities.main

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_user.*
import snu.kr.helptohelp.R
import snu.kr.helptohelp.activities.main.fragments.FutureEventsFragment
import snu.kr.helptohelp.activities.main.fragments.PastEventsFragment
import snu.kr.helptohelp.activities.profile.UserProfileView
import snu.kr.helptohelp.activities.search.SearchResultView
import snu.kr.helptohelp.activities.userPage.util.ViewPagerAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViewPager()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId){
            R.id.action_profile -> startActivity(Intent(this, UserProfileView::class.java))
        }
        return true
    }

    fun setupViewPager() {
        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
        viewPagerAdapter.addFragment(FutureEventsFragment(), "Future Events")
        viewPagerAdapter.addFragment(PastEventsFragment(), "Past Events")
        view_pager.adapter = viewPagerAdapter
    }

    fun onAdd(view: View){
        startActivity(Intent(this, SearchResultView::class.java))
    }
}
