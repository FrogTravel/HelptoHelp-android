package snu.kr.helptohelp.activities.login

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import snu.kr.helptohelp.R

class LoginView: Login.View, AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

}