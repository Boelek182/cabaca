package com.project.cabaca.feature.ui.book.detail.model

import com.google.gson.annotations.SerializedName

data class GenresItem(
        @field:SerializedName("icon_url")
        val iconUrl: String? = null,

        @field:SerializedName("is_primary")
        val isPrimary: Int? = null,

        @field:SerializedName("count")
        val count: Int? = null,

        @field:SerializedName("id")
        val id: Int? = null,

        @field:SerializedName("title")
        val title: String? = null
)