package com.project.cabaca.feature.ui.genre.books.model

import com.google.gson.annotations.SerializedName

data class BookByGenreResponse(
        @field:SerializedName("result")
        val result: List<BookByGenreResponseResultItem>? = null,

        @field:SerializedName("test")
        val test: Test? = null,

        @field:SerializedName("success")
        val success: Boolean? = null
)