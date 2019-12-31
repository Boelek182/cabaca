package com.project.cabaca.feature.ui.writer.list.model

import com.google.gson.annotations.SerializedName

data class WriterResponseResultItem(
        @field:SerializedName("user_id")
        val userId: Int? = null,

        @field:SerializedName("name")
        val name: String? = null,

        @field:SerializedName("Writer_by_user_id")
        val writerByUserId: WriterByUserId? = null,

        @field:SerializedName("id")
        val id: Int? = null,

        @field:SerializedName("photo_url")
        val photoUrl: String? = null,

        @field:SerializedName("count_follower")
        val countFollower: Int? = null,

        @field:SerializedName("is_following")
        val isFollowing: Boolean? = null,

        @field:SerializedName("username")
        val username: String? = null
)