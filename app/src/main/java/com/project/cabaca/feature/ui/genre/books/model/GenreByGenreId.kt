package com.project.cabaca.feature.ui.genre.books.model

import com.google.gson.annotations.SerializedName

data class GenreByGenreId(
        @field:SerializedName("icon_url")
        val iconUrl: String? = null,

        @field:SerializedName("count")
        val count: Int? = null,

        @field:SerializedName("id")
        val id: Int? = null,

        @field:SerializedName("title")
        val title: String? = null
)