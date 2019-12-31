package com.project.cabaca.feature.ui.writer.list

import com.project.cabaca.feature.ui.writer.list.model.WriterResponseResultItem

interface WriterView {
    fun showLoading()
    fun hideLoading()
    fun getDataSuccess(writerResponseResultItem: ArrayList<WriterResponseResultItem>?)
    fun getDataFailed(message: String?)
}