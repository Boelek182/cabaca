package com.project.cabaca.feature.ui.book.detail

import com.project.cabaca.feature.ui.book.detail.model.BookDetailResponseResult

interface BookDetailView {
    fun showLoading()
    fun hideLoading()
    fun getDataSuccess(bookDetailResponseResult: BookDetailResponseResult?)
    fun getDataFailed(message: String?)
}