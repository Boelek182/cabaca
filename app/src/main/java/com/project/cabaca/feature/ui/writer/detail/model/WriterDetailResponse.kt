package com.project.cabaca.feature.ui.writer.detail.model

import com.google.gson.annotations.SerializedName

data class WriterDetailResponse(
        @field:SerializedName("result")
        val result: WriterDetailResponseResult? = null,

        @field:SerializedName("success")
        val success: Boolean? = null
)