package com.project.cabaca.feature.ui.writer.list

import com.project.cabaca.BuildConfig
import com.project.cabaca.base.ui.BasePresenter
import com.project.cabaca.connection.NetworkCallback
import com.project.cabaca.feature.ui.writer.list.model.WriterResponse
import com.project.cabaca.feature.ui.writer.list.model.WriterResponseResultItem

class WriterPresenter(writerView: WriterView) : BasePresenter<WriterView>() {
    init {
        super.attachView(writerView)
    }

    fun getListWriter() {
        view?.showLoading()
        apiServices?.getWriterList(BuildConfig.API_KEY)?.let {
            addSubscribe(it, object : NetworkCallback<WriterResponse>() {
                override fun onSuccess(model: WriterResponse) {
                    val dataList = ArrayList<WriterResponseResultItem>()
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