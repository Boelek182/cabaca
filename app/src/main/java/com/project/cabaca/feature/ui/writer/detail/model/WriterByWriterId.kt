package com.project.cabaca.feature.ui.writer.detail.model

import com.google.gson.annotations.SerializedName

data class WriterByWriterId(
        @field:SerializedName("user_id")
        val userId: Int? = null,

        @field:SerializedName("id")
        val id: Int? = null,

        @field:SerializedName("User_by_user_id")
        val userByUserId: UserByUserId? = null,

        @field:SerializedName("royalty_id")
        val royaltyId: Any? = null,

        @field:SerializedName("status")
        val status: Any? = null
)