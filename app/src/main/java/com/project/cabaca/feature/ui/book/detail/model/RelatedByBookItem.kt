package com.project.cabaca.feature.ui.book.detail.model

import com.google.gson.annotations.SerializedName

data class RelatedByBookItem(
        @field:SerializedName("cover_url")
        val coverUrl: String? = null,

        @field:SerializedName("id")
        val id: Int? = null,

        @field:SerializedName("title")
        val title: String? = null
)