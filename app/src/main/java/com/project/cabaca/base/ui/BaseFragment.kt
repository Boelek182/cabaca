package com.project.cabaca.base.ui

import android.app.Activity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import io.reactivex.disposables.CompositeDisposable

open class BaseFragment: Fragment() {
    private var activity: Activity? = null
    private var compositeSubscription: CompositeDisposable? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity = getActivity()
    }

    override fun onDestroy() {
        super.onDestroy()
        onUnsubscribe()
    }

    private fun onUnsubscribe() {
        if (compositeSubscription != null) {
            compositeSubscription?.dispose()
        }
    }
}