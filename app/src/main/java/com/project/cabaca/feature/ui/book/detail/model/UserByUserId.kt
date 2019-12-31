package com.project.cabaca.feature.ui.book.detail.model

import com.google.gson.annotations.SerializedName

data class UserByUserId(
        @field:SerializedName("name")
        val name: String? = null,

        @field:SerializedName("id")
        val id: Int? = null,

        @field:SerializedName("photo_url")
        val photoUrl: String? = null,

        @field:SerializedName("username")
        val username: String? = null
)