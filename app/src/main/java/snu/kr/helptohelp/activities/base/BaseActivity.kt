package snu.kr.helptohelp.activities.base

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import snu.kr.helptohelp.activities.login.LoginView
import snu.kr.helptohelp.activities.myEvents.MyEventsActivity
import snu.kr.helptohelp.util.SharedPreferencesHelper

/**
 * This acrivity is for checking if the user is logged in
 */
class BaseActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val userId = SharedPreferencesHelper(this).readUserId()

      //  if(userId == -1){//If there is no ID
      //      startActivity(Intent(this, LoginView::class.java))
      //  }else{
            startActivity(Intent(this, MyEventsActivity::class.java))
      //  }

        this.finish()
    }
}