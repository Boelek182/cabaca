package com.project.cabaca.feature.ui.writer.list.model

import com.google.gson.annotations.SerializedName

data class WriterByUserId(
        @field:SerializedName("user_id")
        val userId: Int? = null,

        @field:SerializedName("id")
        val id: Int? = null,

        @field:SerializedName("schedule_task")
        val scheduleTask: String? = null,

        @field:SerializedName("status")
        val status: Any? = null
)