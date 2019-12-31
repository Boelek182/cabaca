package com.project.cabaca.external.intent

import android.app.Activity
import android.content.Context

inline fun <reified T : Activity> Context.startActivity(vararg params: Pair<String, Any?>) =
        CustomActivity.internalStartActivity(this, T::class.java, params)