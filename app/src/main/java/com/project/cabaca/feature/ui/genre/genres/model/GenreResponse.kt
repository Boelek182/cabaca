package com.project.cabaca.feature.ui.genre.genres.model

import com.google.gson.annotations.SerializedName

data class GenreResponse(
        @field:SerializedName("resource")
        val resource: List<GenreResponseResourceItem>? = null
)