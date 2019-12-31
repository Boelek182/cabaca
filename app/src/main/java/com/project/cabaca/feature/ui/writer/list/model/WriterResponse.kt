package com.project.cabaca.feature.ui.writer.list.model

import com.google.gson.annotations.SerializedName

data class WriterResponse(
        @field:SerializedName("result")
        val result: List<WriterResponseResultItem>? = null,

        @field:SerializedName("success")
        val success: Boolean? = null
)