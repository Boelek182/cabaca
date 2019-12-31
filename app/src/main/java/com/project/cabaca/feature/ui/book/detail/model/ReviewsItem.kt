package com.project.cabaca.feature.ui.book.detail.model

import com.google.gson.annotations.SerializedName

data class ReviewsItem(
        @field:SerializedName("updated_at")
        val updatedAt: String? = null,

        @field:SerializedName("user_id")
        val userId: Int? = null,

        @field:SerializedName("User_by_reviewer_id")
        val userByReviewerId: UserByReviewerId? = null,

        @field:SerializedName("review")
        val review: String? = null,

        @field:SerializedName("rating")
        val rating: Int? = null,

        @field:SerializedName("id")
        val id: Int? = null
)