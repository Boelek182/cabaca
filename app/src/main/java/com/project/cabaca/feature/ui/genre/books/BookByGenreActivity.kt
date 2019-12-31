package com.project.cabaca.feature.ui.genre.books

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.project.cabaca.BuildConfig
import com.project.cabaca.R
import com.project.cabaca.base.mvp.MvpActivity
import com.project.cabaca.external.adapter.setUp
import com.project.cabaca.external.intent.startActivity
import com.project.cabaca.feature.ui.book.detail.BookDetailActivity
import com.project.cabaca.feature.ui.genre.books.model.BookByGenreResponseResultItem
import com.project.cabaca.utils.showDialogJustPositive
import dmax.dialog.SpotsDialog
import kotlinx.android.synthetic.main.activity_book_by_genre.*

class BookByGenreActivity : MvpActivity<BookByGenrePresenter>(), BookByGenreView {

    private var bookByGenrePresenter: BookByGenrePresenter? = null
    private var spotsDialog: AlertDialog? = null
    private var genreId: Int? = null
    private var genreName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_by_genre)

        bookByGenrePresenter = BookByGenrePresenter(this)
        spotsDialog = SpotsDialog.Builder()
                .setContext(this)
                .build()
        if (intent.extras != null){
            genreId = intent.getIntExtra("GENRE_ID", 0)
            genreName = intent.getStringExtra("GENRE_NAME")
        }

        supportActionBar?.title = getString(R.string.txt_genre, genreName)
        supportActionBar?.elevation = 0F
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onStart() {
        super.onStart()

        bookByGenrePresenter?.getListBookByGenre(genreId)
    }

    override fun createPresenter(): BookByGenrePresenter {
        return BookByGenrePresenter(this)
    }

    override fun showLoading() {
        spotsDialog?.show()
    }

    override fun hideLoading() {
        spotsDialog?.dismiss()
    }

    override fun getDataSuccess(bookByGenreResponseResultItem: ArrayList<BookByGenreResponseResultItem>?) {
        if (bookByGenreResponseResultItem != null) {
            activityBookByGenreRcv.setHasFixedSize(true)
            activityBookByGenreRcv.setUp(
                    bookByGenreResponseResultItem,
                    R.layout.item_book,
                    {
                        val cPDraw = CircularProgressDrawable(context)

                        cPDraw.strokeWidth = 5f
                        cPDraw.centerRadius = 30f
                        cPDraw.start()

                        Glide.with(context)
                                .setDefaultRequestOptions(RequestOptions().placeholder(cPDraw))
                                .load(BuildConfig.BASE_URL_IMAGE + it.coverUrl + BuildConfig.API_KEY_IMAGE)
                                .into(findViewById(R.id.itemBookImage))

                        findViewById<TextView>(R.id.itemBookTvTitle).text = it.title
                        findViewById<RatingBar>(R.id.itemBookRating).rating = it.rateSum ?: 0F
                        findViewById<TextView>(R.id.itemBookTvRateSum).text = context.getString(R.string.txt_rate_sum, it.rateSum.toString())
                        findViewById<TextView>(R.id.itemBookTvViewCount).text = context.getString(R.string.txt_view_count, it.viewCount.toString())
                        findViewById<TextView>(R.id.itemBookTvWriter).text = context.getString(R.string.txt_writer, it.writerByWriterId?.userByUserId?.name)
                    },
                    {
                        startActivity<BookDetailActivity>("BOOK_ID" to it.id)
                    },
                    LinearLayoutManager(this)
            )
        }
    }

    override fun getDataFailed(message: String?) {
        showDialogJustPositive(this, "Info", message, "Ok", DialogInterface.OnClickListener { _, _ -> })
    }
}
