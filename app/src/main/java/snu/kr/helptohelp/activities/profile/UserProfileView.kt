package snu.kr.helptohelp.activities.profile

import android.app.Activity
import android.os.Bundle
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import kotlinx.android.synthetic.main.activity_profile.*
import snu.kr.helptohelp.R
import snu.kr.helptohelp.activities.glideUtil.GlideApp
import snu.kr.helptohelp.model.User

class UserProfileView : UserProfile.View, Activity() {
    lateinit var presenter: UserProfilePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_profile)

        presenter = UserProfilePresenter(this)
    }

    override fun getContext() = this

    override fun showUser(user: User) {
        GlideApp.with(this)
                .load(user.imageURL)
                .transform( CircleCrop())
                .override(200,200)
                .into(user_image)

        user_name.text = user.name
    }
}