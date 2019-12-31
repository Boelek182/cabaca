package com.project.cabaca.feature.ui.genre.books.model

import com.google.gson.annotations.SerializedName

data class WriterByWriterId(
        @field:SerializedName("user_id")
        val userId: Int? = null,

        @field:SerializedName("kelas")
        val kelas: Any? = null,

        @field:SerializedName("created_at")
        val createdAt: String? = null,

        @field:SerializedName("id")
        val id: Int? = null,

        @field:SerializedName("schedule_task")
        val scheduleTask: String? = null,

        @field:SerializedName("User_by_user_id")
        val userByUserId: UserByUserId? = null,

        @field:SerializedName("status")
        val status: Any? = null,

        @field:SerializedName("royalty_id")
        val royaltyId: Any? = null
)