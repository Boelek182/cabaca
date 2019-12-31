package com.project.cabaca.feature.ui.book.list

import com.project.cabaca.feature.ui.book.list.model.BookResponseResultItem

interface BookView {
    fun showLoading()
    fun hideLoading()
    fun getDataSuccess(bookResponseResultItem: ArrayList<BookResponseResultItem>?)
    fun getDataFailed(message: String?)
}