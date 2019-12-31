package com.project.cabaca.feature.ui.book.detail.model

import com.google.gson.annotations.SerializedName

data class BookDetailResponseResult(
        @field:SerializedName("Writer_by_writer_id")
        val writerByWriterId: WriterByWriterId? = null,

        @field:SerializedName("is_contract_actived")
        val isContractActived: Boolean? = null,

        @field:SerializedName("challenge_id")
        val challengeId: Any? = null,

        @field:SerializedName("created_at")
        val createdAt: String? = null,

        @field:SerializedName("voted")
        val voted: Boolean? = null,

        @field:SerializedName("BookChapter_by_book_id")
        val bookChapterByBookId: List<BookChapterByBookIdItem?>? = null,

        @field:SerializedName("url_landing")
        val urlLanding: String? = null,

        @field:SerializedName("title")
        val title: String? = null,

        @field:SerializedName("download")
        val download: Any? = null,

        @field:SerializedName("updated_at")
        val updatedAt: String? = null,

        @field:SerializedName("reviews")
        val reviews: List<ReviewsItem?>? = null,

        @field:SerializedName("happyhour")
        val happyhour: Boolean? = null,

        @field:SerializedName("genres")
        val genres: List<GenresItem?>? = null,

        @field:SerializedName("is_update")
        val isUpdate: Boolean? = null,

        @field:SerializedName("Related_by_book")
        val relatedByBook: List<RelatedByBookItem?>? = null,

        @field:SerializedName("book_url")
        val bookUrl: String? = null,

        @field:SerializedName("id")
        val id: Int? = null,

        @field:SerializedName("full_purchase")
        val fullPurchase: Boolean? = null,

        @field:SerializedName("writer_id")
        val writerId: Int? = null,

        @field:SerializedName("vote_count")
        val voteCount: String? = null,

        @field:SerializedName("User_review")
        val userReview: String? = null,

        @field:SerializedName("chapter_count")
        val chapterCount: Int? = null,

        @field:SerializedName("decimal_rate")
        val decimalRate: Double? = null,

        @field:SerializedName("cover_url")
        val coverUrl: String? = null,

        @field:SerializedName("average_rate")
        val averageRate: Int? = null,

        @field:SerializedName("synopsis")
        val synopsis: String? = null,

        @field:SerializedName("isNew")
        val isNew: Boolean? = null,

        @field:SerializedName("schedule_task")
        val scheduleTask: String? = null,

        @field:SerializedName("time_to_vote")
        val timeToVote: Boolean? = null,

        @field:SerializedName("full_purchased")
        val fullPurchased: Boolean? = null,

        @field:SerializedName("nominasi")
        val nominasi: Any? = null,

        @field:SerializedName("daily")
        val daily: String? = null,

        @field:SerializedName("schedule_daily")
        val scheduleDaily: Int? = null,

        @field:SerializedName("category")
        val category: Any? = null,

        @field:SerializedName("full_price")
        val fullPrice: Int? = null,

        @field:SerializedName("view_count")
        val viewCount: Int? = null,

        @field:SerializedName("status")
        val status: String? = null,

        @field:SerializedName("desc")
        val desc: String? = null
)