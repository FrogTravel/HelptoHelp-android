package snu.kr.helptohelp.activities.registration

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_registration.*
import snu.kr.helptohelp.R
import snu.kr.helptohelp.activities.main.MyEventsActivity


class RegistrationView : Registration.View, Activity() {
    lateinit var presenter: Registration.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_registration)

        presenter = RegistrationPresenter(this)
    }

    fun onRegister(view: View){
        presenter.onRegister()
    }

    override fun getFirstPassword() = password.text.toString()

    override fun getLogin() = login.text.toString()

    override fun getName() = name.text.toString()

    override fun getSecondPassword() = password_again.text.toString()

    override fun startMyEventsActivity() {
        setResult(Activity.RESULT_OK)

        this.finish()
        startActivity(Intent(this, MyEventsActivity::class.java))
    }
}