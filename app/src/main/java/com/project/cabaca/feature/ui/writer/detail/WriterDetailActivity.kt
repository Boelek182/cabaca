package com.project.cabaca.feature.ui.writer.detail

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.project.cabaca.BuildConfig
import com.project.cabaca.R
import com.project.cabaca.base.mvp.MvpActivity
import com.project.cabaca.feature.ui.writer.detail.model.WriterDetailResponseResult
import com.project.cabaca.utils.checkNullStrip
import com.project.cabaca.utils.showDialogJustPositive
import dmax.dialog.SpotsDialog
import kotlinx.android.synthetic.main.activity_writer_detail.*

class WriterDetailActivity : MvpActivity<WriterDetailPresenter>(), WriterDetailView {

    private var writerDetailPresenter: WriterDetailPresenter? = null
    private var spotsDialog: AlertDialog? = null
    private var writerId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_writer_detail)

        writerDetailPresenter = WriterDetailPresenter(this)
        spotsDialog = SpotsDialog.Builder()
                .setContext(this)
                .build()
        if (intent.extras != null) {
            writerId = intent.getIntExtra("WRITER_ID", 0)
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

        writerDetailPresenter?.getDetailWriter(writerId)
    }

    override fun createPresenter(): WriterDetailPresenter {
        return WriterDetailPresenter(this)
    }

    override fun showLoading() {
        spotsDialog?.show()
    }

    override fun hideLoading() {
        spotsDialog?.dismiss()
    }

    override fun getDataSuccess(writerDetailResponseResult: WriterDetailResponseResult?) {
        if (writerDetailResponseResult != null) {
            supportActionBar?.title = writerDetailResponseResult.name
            activityWriterDetailTvName.text = writerDetailResponseResult.name
            activityWriterDetailTvUsername.text = writerDetailResponseResult.username

            val cPDraw = CircularProgressDrawable(this)

            cPDraw.strokeWidth = 5f
            cPDraw.centerRadius = 30f
            cPDraw.start()

            Glide.with(this)
                    .setDefaultRequestOptions(RequestOptions().placeholder(cPDraw))
                    .load(BuildConfig.BASE_URL_IMAGE + writerDetailResponseResult.photoUrl + BuildConfig.API_KEY_IMAGE)
                    .into(activityWriterDetailImage)

            activityWriterDetailTvEmail.text = checkNullStrip(writerDetailResponseResult.email)
            activityWriterDetailTvPhone.text = checkNullStrip(writerDetailResponseResult.phone)
            activityWriterDetailTvDescription.text = checkNullStrip(writerDetailResponseResult.deskripsi)
            activityWriterDetailTvGender.text = checkNullStrip(writerDetailResponseResult.gender)
            activityWriterDetailTvBirthday.text = checkNullStrip(writerDetailResponseResult.birthday)
        }
    }

    override fun getDataFailed(message: String?) {
        showDialogJustPositive(this, "Info", message, "Ok", DialogInterface.OnClickListener { _, _ -> })
    }
}
