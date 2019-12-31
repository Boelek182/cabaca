package com.project.cabaca.feature.ui.book.detail

import com.project.cabaca.BuildConfig
import com.project.cabaca.base.ui.BasePresenter
import com.project.cabaca.connection.NetworkCallback
import com.project.cabaca.feature.ui.book.detail.model.BookDetailResponse

class BookDetailPresenter(bookDetailView: BookDetailView) : BasePresenter<BookDetailView>() {
    init {
        super.attachView(bookDetailView)
    }

    fun getDetailBook(bookId: Int?) {
        view?.showLoading()
        apiServices?.getBookDetail(BuildConfig.API_KEY, bookId)?.let {
            addSubscribe(it, object : NetworkCallback<BookDetailResponse>() {
                override fun onSuccess(model: BookDetailResponse) {
                    view?.getDataSuccess(model.result)
                }

                override fun onFailure(message: String?) {
                    view?.getDataFailed(message)
                }

                override fun onFinish() {
                    view?.hideLoading()
                }
            })
        }
    }
}