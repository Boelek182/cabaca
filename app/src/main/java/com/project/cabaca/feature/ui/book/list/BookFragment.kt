package com.project.cabaca.feature.ui.book.list

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.project.cabaca.BuildConfig.API_KEY_IMAGE
import com.project.cabaca.BuildConfig.BASE_URL_IMAGE
import com.project.cabaca.R
import com.project.cabaca.base.mvp.MvpFragment
import com.project.cabaca.external.adapter.setUp
import com.project.cabaca.external.intent.startActivity
import com.project.cabaca.feature.ui.book.detail.BookDetailActivity
import com.project.cabaca.feature.ui.book.list.model.BookResponseResultItem
import com.project.cabaca.utils.showDialogJustPositive
import dmax.dialog.SpotsDialog
import kotlinx.android.synthetic.main.fragment_book.*

class BookFragment : MvpFragment<BookPresenter>(), BookView {

    private var bookPresenter: BookPresenter? = null
    private var spotsDialog: AlertDialog? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_book, container, false)
    }

    override fun onStart() {
        super.onStart()

        bookPresenter = BookPresenter(this)
        spotsDialog = SpotsDialog.Builder()
                .setContext(context)
                .build()

        bookPresenter?.getListBooks()
    }

    override fun createPresenter(): BookPresenter {
        return BookPresenter(this)
    }

    override fun showLoading() {
        spotsDialog?.show()
    }

    override fun hideLoading() {
        spotsDialog?.dismiss()
    }

    override fun getDataSuccess(bookResponseResultItem: ArrayList<BookResponseResultItem>?) {
        if (bookResponseResultItem != null) {
            fragmentBookRcv.setHasFixedSize(true)
            fragmentBookRcv.setUp(
                    bookResponseResultItem,
                    R.layout.item_book,
                    {
                        val cPDraw = CircularProgressDrawable(context)

                        cPDraw.strokeWidth = 5f
                        cPDraw.centerRadius = 30f
                        cPDraw.start()

                        Glide.with(context)
                                .setDefaultRequestOptions(RequestOptions().placeholder(cPDraw))
                                .load(BASE_URL_IMAGE + it.coverUrl + API_KEY_IMAGE)
                                .into(findViewById(R.id.itemBookImage))

                        findViewById<TextView>(R.id.itemBookTvTitle).text = it.title
                        findViewById<RatingBar>(R.id.itemBookRating).rating = it.rateSum ?: 0F
                        findViewById<TextView>(R.id.itemBookTvRateSum).text = context.getString(R.string.txt_rate_sum, it.rateSum.toString())
                        findViewById<TextView>(R.id.itemBookTvViewCount).text = context.getString(R.string.txt_view_count, it.viewCount.toString())
                        findViewById<TextView>(R.id.itemBookTvWriter).text = context.getString(R.string.txt_writer, it.writerByWriterId?.userByUserId?.name)
                    },
                    {
                        context.startActivity<BookDetailActivity>("BOOK_ID" to it.bookId)
                    },
                    LinearLayoutManager(context)
            )
        }
    }

    override fun getDataFailed(message: String?) {
        showDialogJustPositive(context, "Info Book", message, "Ok", DialogInterface.OnClickListener { _, _ -> })
    }
}