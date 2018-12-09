package snu.kr.helptohelp.activities.personalPage

import android.app.Activity
import android.os.Bundle
import android.view.View
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_edit_profile.*
import kotlinx.android.synthetic.main.activity_profile.*
import snu.kr.helptohelp.R
import snu.kr.helptohelp.activities.glideUtil.GlideApp
import snu.kr.helptohelp.activities.personalPage.util.TagAdapter
import snu.kr.helptohelp.model.Tag
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
                .load(user.profile_pic)
                .placeholder(R.mipmap.ic_launcher)
                .override(400,400)
                .dontAnimate()//Some problem with placeholders in Glide
                .circleCrop()
                .into(user_image)

        user_name.text = user.name
        desctiption_text_view.text = user.description

        verified_sign.visibility = if(user.isVerified) View.VISIBLE else View.GONE

        age.text = user.age.toString()

        address.text = user.address
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
                .load(user.profile_pic)
                .transform( CircleCrop())
                .override(400,400)
                .into(user_image_edit)

        user_name_edit_text.setText(user.name)
        description_edit_text.setText(user.description)
    }

    override fun getNewUserDescription() = description_edit_text.text.toString()

    override fun showTags(tags: ArrayList<Tag>) {
        tags_rv.adapter = TagAdapter(tags)
        val flexboxLayoutManager = FlexboxLayoutManager(this)
        flexboxLayoutManager.apply {
            flexDirection = FlexDirection.ROW
            justifyContent = JustifyContent.FLEX_START
        }
        tags_rv.layoutManager = flexboxLayoutManager
    }
}