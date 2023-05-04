package com.example.lovecolculation

import android.content.Context
import android.content.SharedPreferences

class Pref(context: Context) {
    private var pref: SharedPreferences? =
        context.getSharedPreferences("setting", Context.MODE_PRIVATE)

    fun isUserSeenOnBoarding() {
        pref?.edit()?.putBoolean(SEEN_KEY, true)?.apply()
    }

    fun isUserSeen(): Boolean {
        return pref!!.getBoolean(SEEN_KEY, false)
    }

    companion object {
        const val SEEN_KEY = "isShow"
    }
}