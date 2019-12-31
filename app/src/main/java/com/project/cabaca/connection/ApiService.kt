package com.project.cabaca.connection

import com.project.cabaca.feature.ui.book.detail.model.BookDetailResponse
import com.project.cabaca.feature.ui.book.list.model.BookResponse
import com.project.cabaca.feature.ui.genre.books.model.BookByGenreResponse
import com.project.cabaca.feature.ui.genre.genres.model.GenreResponse
import com.project.cabaca.feature.ui.writer.detail.model.WriterDetailResponse
import com.project.cabaca.feature.ui.writer.list.model.WriterResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("cabaca/_table/genre")
    fun getGenreList(@Header("x-dreamfactory-api-key") apiKey: String?): Observable<GenreResponse>?

    @GET("book/category")
    fun getBookByGenre(@Header("x-dreamfactory-api-key") apiKey: String?,
                       @Query(value = "id", encoded = true) genreId: Int?): Observable<BookByGenreResponse>?

    @GET("book/uptodate?limit=7")
    fun getBookList(@Header("x-dreamfactory-api-key") apiKey: String?): Observable<BookResponse>?

    @GET("book/detail/{bookId}")
    fun getBookDetail(@Header("x-dreamfactory-api-key") apiKey: String?,
                      @Path(value = "bookId", encoded = true) bookId: Int?): Observable<BookDetailResponse>?

    @GET("writer/popular?limit=10")
    fun getWriterList(@Header("x-dreamfactory-api-key") apiKey: String?): Observable<WriterResponse>?

    @GET("writer/detail/{writerId}")
    fun getWriterDetail(@Header("x-dreamfactory-api-key") apiKey: String?,
                        @Path(value = "writerId", encoded = true) writerId: Int?): Observable<WriterDetailResponse>?
}