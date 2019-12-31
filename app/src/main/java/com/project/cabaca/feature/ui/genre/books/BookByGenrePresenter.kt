package com.project.cabaca.feature.ui.genre.books

import com.project.cabaca.BuildConfig
import com.project.cabaca.base.ui.BasePresenter
import com.project.cabaca.connection.NetworkCallback
import com.project.cabaca.feature.ui.genre.books.model.BookByGenreResponse
import com.project.cabaca.feature.ui.genre.books.model.BookByGenreResponseResultItem

class BookByGenrePresenter(bookByGenreView: BookByGenreView) : BasePresenter<BookByGenreView>() {
    init {
        super.attachView(bookByGenreView)
    }

    fun getListBookByGenre(genreId: Int?) {
        view?.showLoading()
        apiServices?.getBookByGenre(BuildConfig.API_KEY, genreId)?.let {
            addSubscribe(it, object : NetworkCallback<BookByGenreResponse>() {
                override fun onSuccess(model: BookByGenreResponse) {
                    val dataList = ArrayList<BookByGenreResponseResultItem>()
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