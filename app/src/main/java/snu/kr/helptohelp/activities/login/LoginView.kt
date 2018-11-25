package snu.kr.helptohelp.activities.login

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_login.*
import snu.kr.helptohelp.R
import android.widget.Toast
import android.app.Activity
import android.content.Intent
import snu.kr.helptohelp.activities.myEvents.MyEventsActivity
import snu.kr.helptohelp.activities.registration.RegistrationView


class LoginView: Login.View, AppCompatActivity(){
    lateinit var presenter: Login.Presenter
    private val RESULT_CODE = 1

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
        startActivityForResult(Intent(this, RegistrationView::class.java), RESULT_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == RESULT_CODE){
            if(resultCode == Activity.RESULT_OK){
                this.finish()
            }
        }
    }

}