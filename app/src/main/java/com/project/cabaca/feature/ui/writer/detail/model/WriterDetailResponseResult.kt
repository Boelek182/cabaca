package com.project.cabaca.feature.ui.writer.detail.model

import com.google.gson.annotations.SerializedName

data class WriterDetailResponseResult(
        @field:SerializedName("birthday")
        val birthday: String? = null,

        @field:SerializedName("gender")
        val gender: String? = null,

        @field:SerializedName("count_following")
        val countFollowing: Int? = null,

        @field:SerializedName("current_level")
        val currentLevel: Int? = null,

        @field:SerializedName("Writer_by_user_id")
        val writerByUserId: WriterByUserId? = null,

        @field:SerializedName("reading_list")
        val readingList: List<ReadingListItem?>? = null,

        @field:SerializedName("writer_level")
        val writerLevel: Int? = null,

        @field:SerializedName("phone")
        val phone: String? = null,

        @field:SerializedName("karya")
        val karya: List<KaryaItem?>? = null,

        @field:SerializedName("name")
        val name: String? = null,

        @field:SerializedName("following_user")
        val followingUser: List<Any?>? = null,

        @field:SerializedName("id")
        val id: Int? = null,

        @field:SerializedName("photo_url")
        val photoUrl: String? = null,

        @field:SerializedName("deskripsi")
        val deskripsi: String? = null,

        @field:SerializedName("writer_level_name")
        val writerLevelName: Any? = null,

        @field:SerializedName("writer_id")
        val writerId: Int? = null,

        @field:SerializedName("count_follower")
        val countFollower: Int? = null,

        @field:SerializedName("is_following")
        val isFollowing: Boolean? = null,

        @field:SerializedName("email")
        val email: String? = null,

        @field:SerializedName("username")
        val username: String? = null,

        @field:SerializedName("link_user")
        val linkUser: String? = null,

        @field:SerializedName("coin")
        val coin: Int? = null
)