package com.project.cabaca.feature.ui.book.list.model

import com.google.gson.annotations.SerializedName

data class UserByUserId(
        @field:SerializedName("name")
        val name: String? = null,

        @field:SerializedName("id")
        val id: Int? = null
)