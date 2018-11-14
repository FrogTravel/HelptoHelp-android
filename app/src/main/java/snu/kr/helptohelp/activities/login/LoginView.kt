package snu.kr.helptohelp.activities.login

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_login.*
import snu.kr.helptohelp.R
import snu.kr.helptohelp.util.SharedPreferencesHelper
import android.widget.Toast
import android.R.attr.data
import android.content.Intent
import snu.kr.helptohelp.activities.main.MyEventsActivity
import snu.kr.helptohelp.activities.personalPage.PersonalPageView
import snu.kr.helptohelp.activities.registration.RegistrationView


class LoginView: Login.View, AppCompatActivity(){
    lateinit var presenter: Login.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        presenter = LoginPresenter(this)
    }

    fun onLogin(view : View){
        presenter.onLoginButton()
    }

    override fun getContext() = this

    override fun getPassword() = password.text.toString()

    override fun getLogin() = login.text.toString()

    override fun showLoginError() {
        Toast.makeText(this, resources.getString(R.string.login_error),
                Toast.LENGTH_LONG).show()
    }

    override fun showNotRegisteredError() {
        Toast.makeText(this, resources.getString(R.string.password_error),
                Toast.LENGTH_LONG).show()
    }

    override fun startMyEventsActivity() {
        startActivity(Intent(this, MyEventsActivity::class.java))
    }

    fun onRegister(view: View){
        startActivity(Intent(this, RegistrationView::class.java))
    }

}