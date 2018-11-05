package snu.kr.helptohelp.activities.filterSearch

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import snu.kr.helptohelp.R
import snu.kr.helptohelp.model.SearchQuery

class FilterSearchView : FilterSearch.View, Activity() {
    companion object {
        val RESULT_NAME = "result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_filter)
    }

    fun onSearch(view: View){
        val returnIntent = Intent()
        returnIntent.putExtra("result", SearchQuery(1, "Seoul"))
        setResult(Activity.RESULT_OK, returnIntent)
        finish()
    }
}