package snu.kr.helptohelp.activities.search

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_search.*
import snu.kr.helptohelp.R
import snu.kr.helptohelp.model.SearchQuery
import snu.kr.helptohelp.model.User
import snu.kr.helptohelp.activities.filterSearch.FilterSearchView
import snu.kr.helptohelp.activities.search.util.SearchResultAdapter

class SearchResultView : SearchResult.View, Activity() {
    companion object {
        val EXtRA_USER_ID = "user_id"
    }
    lateinit var presenter: SearchResultPresenter
    val SEARCH_PEOPLE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_search)

        presenter = SearchResultPresenter(this)
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