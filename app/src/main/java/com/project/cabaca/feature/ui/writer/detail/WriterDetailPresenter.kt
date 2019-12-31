package com.project.cabaca.feature.ui.writer.detail

import com.project.cabaca.BuildConfig
import com.project.cabaca.base.ui.BasePresenter
import com.project.cabaca.connection.NetworkCallback
import com.project.cabaca.feature.ui.writer.detail.model.WriterDetailResponse

class WriterDetailPresenter(writerDetailView: WriterDetailView) : BasePresenter<WriterDetailView>() {
    init {
        super.attachView(writerDetailView)
    }

    fun getDetailWriter(writerId: Int?) {
        view?.showLoading()
        apiServices?.getWriterDetail(BuildConfig.API_KEY, writerId)?.let {
            addSubscribe(it, object : NetworkCallback<WriterDetailResponse>() {
                override fun onSuccess(model: WriterDetailResponse) {
                    view?.getDataSuccess(model.result)
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