package com.project.cabaca.feature.ui.book.list

import com.project.cabaca.BuildConfig
import com.project.cabaca.base.ui.BasePresenter
import com.project.cabaca.connection.NetworkCallback
import com.project.cabaca.feature.ui.book.list.model.BookResponse
import com.project.cabaca.feature.ui.book.list.model.BookResponseResultItem

class BookPresenter(bookView: BookView) : BasePresenter<BookView>() {
    init {
        super.attachView(bookView)
    }

    fun getListBooks() {
        view?.showLoading()
        apiServices?.getBookList(BuildConfig.API_KEY)?.let {
            addSubscribe(it, object : NetworkCallback<BookResponse>() {
                override fun onSuccess(model: BookResponse) {
                    val dataList = ArrayList<BookResponseResultItem>()
                    model.result?.forEach { case ->
                        dataList.add(case)
                    }
                    view?.getDataSuccess(dataList)
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