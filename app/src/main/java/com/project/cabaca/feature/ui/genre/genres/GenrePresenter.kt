package com.project.cabaca.feature.ui.genre.genres

import com.project.cabaca.BuildConfig.API_KEY
import com.project.cabaca.base.ui.BasePresenter
import com.project.cabaca.connection.NetworkCallback
import com.project.cabaca.feature.ui.genre.genres.model.GenreResponse
import com.project.cabaca.feature.ui.genre.genres.model.GenreResponseResourceItem

class GenrePresenter(genreView: GenreView) : BasePresenter<GenreView>() {
    init {
        super.attachView(genreView)
    }

    fun getListGenre() {
        view?.showLoading()
        apiServices?.getGenreList(API_KEY)?.let {
            addSubscribe(it, object : NetworkCallback<GenreResponse>() {
                override fun onSuccess(model: GenreResponse) {
                    val dataList = ArrayList<GenreResponseResourceItem>()
                    model.resource?.forEach { case ->
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