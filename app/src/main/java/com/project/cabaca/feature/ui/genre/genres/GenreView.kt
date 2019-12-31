package com.project.cabaca.feature.ui.genre.genres

import com.project.cabaca.feature.ui.genre.genres.model.GenreResponseResourceItem

interface GenreView {
    fun showLoading()
    fun hideLoading()
    fun getDataSuccess(genreResponseResourceItem: ArrayList<GenreResponseResourceItem>?)
    fun getDataFailed(message: String?)
}