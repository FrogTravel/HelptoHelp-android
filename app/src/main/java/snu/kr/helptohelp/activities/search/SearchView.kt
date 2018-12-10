package snu.kr.helptohelp.activities.search

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_filter.*
import kotlinx.android.synthetic.main.activity_profile.*
import snu.kr.helptohelp.R
import snu.kr.helptohelp.model.SearchQuery

class SearchView : Search.View, AppCompatActivity() {
    companion object {
        val RESULT_NAME = "result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_filter)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> this.finish()
        }
        return true
    }

    fun onSearch(view: View){
        val returnIntent = Intent()
        returnIntent.putExtra("result", SearchQuery(
                language = language_edit_text.text.toString(),
                address = address_edit_text.text.toString(),
                name = name_edit_text.text.toString()
        ))
        setResult(Activity.RESULT_OK, returnIntent)
        finish()
    }
}