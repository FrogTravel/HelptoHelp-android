package snu.kr.helptohelp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import snu.kr.helptohelp.activities.search.SearchResultView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startActivity(Intent(this, SearchResultView::class.java))
    }
}
