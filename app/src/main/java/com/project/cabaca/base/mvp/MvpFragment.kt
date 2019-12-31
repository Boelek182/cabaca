package com.project.cabaca.base.mvp

import android.os.Bundle
import android.view.View
import com.project.cabaca.base.ui.BaseFragment
import com.project.cabaca.base.ui.BasePresenter

abstract class MvpFragment<P : BasePresenter<*>> : BaseFragment() {
    private var presenter: P? = null
    protected abstract fun createPresenter(): P

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = createPresenter()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (presenter != null) {
            presenter?.detachView()
            presenter?.stop()
        }
    }
}