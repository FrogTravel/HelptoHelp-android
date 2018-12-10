package snu.kr.helptohelp.activities.userPage.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.flexbox.AlignItems
import com.google.android.flexbox.FlexboxLayoutManager
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.fragment_profile.view.*
import snu.kr.helptohelp.R
import snu.kr.helptohelp.activities.userPage.util.FoodTypeRecyclerView
import snu.kr.helptohelp.model.User

class FragmentUser : Fragment() {
    companion object {
        val USER_NAME = "user_name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val user = arguments?.getSerializable(USER_NAME) as User

        user_name.text = user.name
        age.text = "age: ${user.age}"
        language.text = "language: ${user.language}"
        description.text = user.description
        val flexboxLayoutManager = FlexboxLayoutManager(this.context)
        flexboxLayoutManager.alignItems = AlignItems.FLEX_START
        food_types.layoutManager = flexboxLayoutManager
        food_types.adapter = FoodTypeRecyclerView(user.tags)
        experience.text = "experience: ${user.experience}"
    }

}

