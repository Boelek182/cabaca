package com.project.cabaca.feature.ui.book.detail.model

import com.google.gson.annotations.SerializedName

data class BookChapterByBookIdItem(
        @field:SerializedName("new")
        val jsonMemberNew: Boolean? = null,

        @field:SerializedName("like_count")
        val likeCount: Int? = null,

        @field:SerializedName("is_readed")
        val isReaded: Boolean? = null,

        @field:SerializedName("created_at")
        val createdAt: String? = null,

        @field:SerializedName("book_id")
        val bookId: Int? = null,

        @field:SerializedName("title")
        val title: String? = null,

        @field:SerializedName("schedule_task")
        val scheduleTask: String? = null,

        @field:SerializedName("view_by_user")
        val viewByUser: Int? = null,

        @field:SerializedName("is_warning")
        val isWarning: Any? = null,

        @field:SerializedName("price")
        val price: Int? = null,

        @field:SerializedName("chapter_sequence")
        val chapterSequence: Int? = null,

        @field:SerializedName("id")
        val id: Int? = null,

        @field:SerializedName("view_count")
        val viewCount: Int? = null,

        @field:SerializedName("is_purchased")
        val isPurchased: Boolean? = null
)