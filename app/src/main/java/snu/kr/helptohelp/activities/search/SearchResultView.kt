package snu.kr.helptohelp.activities.search

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_search.*
import snu.kr.helptohelp.R
import snu.kr.helptohelp.model.SearchQuery
import snu.kr.helptohelp.model.User
import snu.kr.helptohelp.activities.filterSearch.FilterSearchView
import snu.kr.helptohelp.activities.profile.UserProfileView
import snu.kr.helptohelp.activities.search.util.SearchResultAdapter

class SearchResultView : SearchResult.View, AppCompatActivity() {
    companion object {
        val EXTRA_USER_ID = "user_id"
    }
    lateinit var presenter: SearchResultPresenter
    val SEARCH_PEOPLE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_search)

        presenter = SearchResultPresenter(this)
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

    fun onSearchButton(view: View){
        presenter.onSearchButton()
    }

    override fun searchForPeople() {
        startActivityForResult(Intent(this, FilterSearchView::class.java), SEARCH_PEOPLE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == SEARCH_PEOPLE) {
            if (resultCode == Activity.RESULT_OK) {
                presenter.setSearchQuery(data?.getSerializableExtra(FilterSearchView.RESULT_NAME) as SearchQuery)
            }
        }
    }

    override fun showUsers(users: List<User>){
        user_recyclers.adapter = SearchResultAdapter(users)
        user_recyclers.layoutManager = LinearLayoutManager(this)
    }


}