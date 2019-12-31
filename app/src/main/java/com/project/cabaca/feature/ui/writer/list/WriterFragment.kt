package com.project.cabaca.feature.ui.writer.list

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.project.cabaca.BuildConfig
import com.project.cabaca.R
import com.project.cabaca.base.mvp.MvpFragment
import com.project.cabaca.external.adapter.setUp
import com.project.cabaca.external.intent.startActivity
import com.project.cabaca.feature.ui.writer.detail.WriterDetailActivity
import com.project.cabaca.feature.ui.writer.list.model.WriterResponseResultItem
import com.project.cabaca.utils.showDialogJustPositive
import dmax.dialog.SpotsDialog
import kotlinx.android.synthetic.main.fragment_writer.*

class WriterFragment : MvpFragment<WriterPresenter>(), WriterView {

    private var writerPresenter: WriterPresenter? = null
    private var spotsDialog: AlertDialog? = null

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_writer, container, false)
    }

    override fun onStart() {
        super.onStart()

        writerPresenter = WriterPresenter(this)
        spotsDialog = SpotsDialog.Builder()
                .setContext(context)
                .build()

        writerPresenter?.getListWriter()
    }

    override fun createPresenter(): WriterPresenter {
        return WriterPresenter(this)
    }

    override fun showLoading() {
        spotsDialog?.show()
    }

    override fun hideLoading() {
        spotsDialog?.dismiss()
    }

    override fun getDataSuccess(writerResponseResultItem: ArrayList<WriterResponseResultItem>?) {
        if (writerResponseResultItem != null) {
            fragmentWriterRcv.setHasFixedSize(true)
            fragmentWriterRcv.setUp(
                    writerResponseResultItem,
                    R.layout.item_writer,
                    {
                        val cPDraw = CircularProgressDrawable(context)

                        cPDraw.strokeWidth = 5f
                        cPDraw.centerRadius = 30f
                        cPDraw.start()

                        Glide.with(context)
                                .setDefaultRequestOptions(RequestOptions().placeholder(cPDraw))
                                .load(BuildConfig.BASE_URL_IMAGE + it.photoUrl + BuildConfig.API_KEY_IMAGE)
                                .into(findViewById(R.id.itemWriterProfile))

                        findViewById<TextView>(R.id.itemWriterTvName).text = it.name
                        findViewById<TextView>(R.id.itemWriterTvUsername).text = context.getString(R.string.txt_username, it.username)
                        findViewById<TextView>(R.id.itemWriterTvFollowers).text = context.getString(R.string.txt_follower, it.countFollower.toString())
                    },
                    {
                        context.startActivity<WriterDetailActivity>("WRITER_ID" to it.userId)
                    },
                    LinearLayoutManager(context)
            )
        }
    }

    override fun getDataFailed(message: String?) {
        showDialogJustPositive(context, "Info Writer", message, "Ok", DialogInterface.OnClickListener { _, _ -> })
    }
}