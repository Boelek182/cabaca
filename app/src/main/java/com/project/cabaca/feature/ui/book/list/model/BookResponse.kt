package com.project.cabaca.feature.ui.book.list.model

import com.google.gson.annotations.SerializedName

data class BookResponse(
        @field:SerializedName("result")
        val result: List<BookResponseResultItem>? = null,

        @field:SerializedName("success")
        val success: Boolean? = null
)