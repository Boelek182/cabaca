package com.project.cabaca.feature.ui.genre.books

import com.project.cabaca.feature.ui.genre.books.model.BookByGenreResponseResultItem

interface BookByGenreView {
    fun showLoading()
    fun hideLoading()
    fun getDataSuccess(bookByGenreResponseResultItem: ArrayList<BookByGenreResponseResultItem>?)
    fun getDataFailed(message: String?)
}