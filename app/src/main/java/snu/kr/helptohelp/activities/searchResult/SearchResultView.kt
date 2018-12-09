package snu.kr.helptohelp.activities.searchResult

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_search.*
import snu.kr.helptohelp.R
import snu.kr.helptohelp.model.SearchQuery
import snu.kr.helptohelp.activities.search.SearchView
import snu.kr.helptohelp.activities.personalPage.PersonalPageView
import snu.kr.helptohelp.activities.searchResult.util.SearchResultAdapter
import snu.kr.helptohelp.model.event.Event

class SearchResultView : SearchResult.View, AppCompatActivity() {
    lateinit var presenter: SearchResultPresenter
    val SEARCH_PEOPLE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_search)
        startActivityForResult(Intent(this, SearchView::class.java), SEARCH_PEOPLE)

        presenter = SearchResultPresenter(this)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.action_profile -> {
                startActivity(Intent(this, PersonalPageView::class.java))
            }
            android.R.id.home -> this.finish()
        }
        return true
    }

    fun onSearchButton(view: View) {
        presenter.onSearchButton()
    }

    override fun searchForPeople() {
        startActivityForResult(Intent(this, SearchView::class.java), SEARCH_PEOPLE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == SEARCH_PEOPLE) {
            if (resultCode == Activity.RESULT_OK) {
                presenter.setSearchQuery(data?.getSerializableExtra(SearchView.RESULT_NAME) as SearchQuery)
            }
        }
    }

    override fun showResults(events: List<Event>) {

        result_recyclers.adapter = SearchResultAdapter(events)
        result_recyclers.layoutManager = LinearLayoutManager(this)

        error.visibility = View.GONE
    }

    override fun showError() {
        error.text = resources.getString(R.string.error_search)
    }


}