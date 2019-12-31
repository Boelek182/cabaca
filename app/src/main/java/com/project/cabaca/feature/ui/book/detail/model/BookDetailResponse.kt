package com.project.cabaca.feature.ui.book.detail.model

import com.google.gson.annotations.SerializedName

data class BookDetailResponse(
        @field:SerializedName("result")
        val result: BookDetailResponseResult? = null,

        @field:SerializedName("success")
        val success: Boolean? = null
)