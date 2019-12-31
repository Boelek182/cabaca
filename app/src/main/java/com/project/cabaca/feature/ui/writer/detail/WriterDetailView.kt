package com.project.cabaca.feature.ui.writer.detail

import com.project.cabaca.feature.ui.writer.detail.model.WriterDetailResponseResult

interface WriterDetailView {
    fun showLoading()
    fun hideLoading()
    fun getDataSuccess(writerDetailResponseResult: WriterDetailResponseResult?)
    fun getDataFailed(message: String?)
}