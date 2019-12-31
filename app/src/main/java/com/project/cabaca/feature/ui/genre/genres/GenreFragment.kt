package com.project.cabaca.feature.ui.genre.genres

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.cabaca.R
import com.project.cabaca.base.mvp.MvpFragment
import com.project.cabaca.external.adapter.setUp
import com.project.cabaca.external.intent.startActivity
import com.project.cabaca.feature.ui.genre.books.BookByGenreActivity
import com.project.cabaca.feature.ui.genre.genres.model.GenreResponseResourceItem
import com.project.cabaca.utils.showDialogJustPositive
import dmax.dialog.SpotsDialog
import kotlinx.android.synthetic.main.fragment_genre.*

class GenreFragment : MvpFragment<GenrePresenter>(), GenreView {

    private var genrePresenter: GenrePresenter? = null
    private var spotsDialog: AlertDialog? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_genre, container, false)
    }

    override fun onStart() {
        super.onStart()

        genrePresenter = GenrePresenter(this)
        spotsDialog = SpotsDialog.Builder()
                .setContext(context)
                .build()

        genrePresenter?.getListGenre()
    }

    override fun createPresenter(): GenrePresenter {
        return GenrePresenter(this)
    }

    override fun showLoading() {
        spotsDialog?.show()
    }

    override fun hideLoading() {
        spotsDialog?.dismiss()
    }

    override fun getDataSuccess(genreResponseResourceItem: ArrayList<GenreResponseResourceItem>?) {
        if (genreResponseResourceItem != null) {
            fragmentGenreRcv.setHasFixedSize(true)
            fragmentGenreRcv.setUp(
                    genreResponseResourceItem,
                    R.layout.item_genre,
                    {
                        findViewById<TextView>(R.id.itemGenreTv).text = it.title
                    },
                    {
                        context.startActivity<BookByGenreActivity>("GENRE_ID" to it.id, "GENRE_NAME" to it.title)
                    },
                    LinearLayoutManager(context)
            )
        }
    }

    override fun getDataFailed(message: String?) {
        showDialogJustPositive(context, "Info Genre", message, "Ok", DialogInterface.OnClickListener { _, _ -> })
    }
}