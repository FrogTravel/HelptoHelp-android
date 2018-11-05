package snu.kr.helptohelp.util

import android.content.Context
import snu.kr.helptohelp.BuildConfig

class SharedPreferencesHelper(context: Context) {
    private val preferences = context.getSharedPreferences(BuildConfig.SHARED_PREFERENCES_CONFIG_NAME, Context.MODE_PRIVATE)
    private val LOCAL_USER_ID = "LOCAL_USER_ID"

    public fun writeUserId(userId: Int) {
        val editor = preferences.edit()
        editor.putInt(LOCAL_USER_ID, userId)
        editor.apply()
    }

    public fun readUserId()  = preferences.getInt(LOCAL_USER_ID, -1)
}