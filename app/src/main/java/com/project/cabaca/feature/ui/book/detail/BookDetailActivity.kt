package com.project.cabaca.feature.ui.book.detail

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.core.text.HtmlCompat.FROM_HTML_MODE_COMPACT
import androidx.core.text.HtmlCompat.fromHtml
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.project.cabaca.BuildConfig
import com.project.cabaca.R
import com.project.cabaca.base.mvp.MvpActivity
import com.project.cabaca.feature.ui.book.detail.model.BookDetailResponseResult
import com.project.cabaca.utils.checkNullStrip
import com.project.cabaca.utils.showDialogJustPositive
import dmax.dialog.SpotsDialog
import kotlinx.android.synthetic.main.activity_book_detail.*

class BookDetailActivity : MvpActivity<BookDetailPresenter>(), BookDetailView {

    private var bookDetailPresenter: BookDetailPresenter? = null
    private var spotsDialog: AlertDialog? = null
    private var bookId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_detail)

        bookDetailPresenter = BookDetailPresenter(this)
        spotsDialog = SpotsDialog.Builder()
                .setContext(this)
                .build()
        if (intent.extras != null) {
            bookId = intent.getIntExtra("BOOK_ID", 0)
        }

        supportActionBar?.elevation = 0F
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onStart() {
        super.onStart()

        bookDetailPresenter?.getDetailBook(bookId)
    }

    override fun createPresenter(): BookDetailPresenter {
        return BookDetailPresenter(this)
    }

    override fun showLoading() {
        spotsDialog?.show()
    }

    override fun hideLoading() {
        spotsDialog?.dismiss()
    }

    override fun getDataSuccess(bookDetailResponseResult: BookDetailResponseResult?) {
        if (bookDetailResponseResult != null) {
            supportActionBar?.title = bookDetailResponseResult.title
            activityBookDetailTvTitle.text = bookDetailResponseResult.title

            val cPDraw = CircularProgressDrawable(this)

            cPDraw.strokeWidth = 5f
            cPDraw.centerRadius = 30f
            cPDraw.start()

            Glide.with(this)
                    .setDefaultRequestOptions(RequestOptions().placeholder(cPDraw))
                    .load(BuildConfig.BASE_URL_IMAGE + bookDetailResponseResult.coverUrl + BuildConfig.API_KEY_IMAGE)
                    .into(activityBookDetailImage)

            activityBookDetailTvSynopsis.text = fromHtml(checkNullStrip(bookDetailResponseResult.synopsis), FROM_HTML_MODE_COMPACT)
            activityBookDetailTvWriter.text = checkNullStrip(bookDetailResponseResult.writerByWriterId?.userByUserId?.username)
            activityBookDetailTvUrlLanding.text = fromHtml(checkNullStrip(bookDetailResponseResult.urlLanding), FROM_HTML_MODE_COMPACT)
            activityBookDetailTvUrlLanding.setOnClickListener {
                val uri = Uri.parse(bookDetailResponseResult.urlLanding)
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(intent)
            }
            activityBookDetailTvDescription.text = fromHtml(checkNullStrip(bookDetailResponseResult.desc), FROM_HTML_MODE_COMPACT)
        }
    }

    override fun getDataFailed(message: String?) {
        showDialogJustPositive(this, "Info", message, "Ok", DialogInterface.OnClickListener { _, _ -> })
    }
}
