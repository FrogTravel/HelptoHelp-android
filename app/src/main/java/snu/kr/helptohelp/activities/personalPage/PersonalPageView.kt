package snu.kr.helptohelp.activities.personalPage

import android.app.Activity
import android.os.Bundle
import android.view.View
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_edit_profile.*
import kotlinx.android.synthetic.main.activity_profile.*
import snu.kr.helptohelp.R
import snu.kr.helptohelp.activities.glideUtil.GlideApp
import snu.kr.helptohelp.model.User

class PersonalPageView : PersonalPage.View, Activity() {
    lateinit var presenter: PersonalPage.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_profile)

        presenter = PersonalPagePresenter(this)
    }

    override fun getContext() = this

    override fun showUser(user: User) {
        GlideApp.with(this)
                .load(user.imageURL)
                .transform( CircleCrop())
                .override(400,400)
                .into(user_image)

        user_name.text = user.name
        desctiption_text_view.text = user.description
    }


    fun onEdit(view: View){
        presenter.onModeChange()
    }

    override fun showEditMode() {
        setContentView(R.layout.activity_edit_profile)
        clearFindViewByIdCache()
    }

    override fun showProfileMode() {
        setContentView(R.layout.activity_profile)
        clearFindViewByIdCache()
    }

    fun onSave(view: View){
        presenter.saveUser()

        presenter.onModeChange()
    }

    override fun getNewUserName() = user_name_edit_text.text.toString()

    override fun showUserEdit(user: User) {
        GlideApp.with(this)
                .load(user.imageURL)
                .transform( CircleCrop())
                .override(400,400)
                .into(user_image_edit)

        user_name_edit_text.setText(user.name)
        description_edit_text.setText(user.description)
    }

    override fun getNewUserDescription() = description_edit_text.text.toString()
}