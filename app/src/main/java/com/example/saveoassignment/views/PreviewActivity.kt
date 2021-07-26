package com.example.saveoassignment.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.example.saveoassignment.R
import kotlinx.android.synthetic.main.activity_preview.*

class PreviewActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)
        getDataFromIntent()
        populateUi()
    }

    private fun populateUi() {

       var  image = intent.getStringExtra("image")
       var  title = intent.getStringExtra("title")
       var summary = intent.getStringExtra("summary")
       var time= intent.getStringExtra("time")
       var  date=intent.getStringExtra("date")
       var type=intent.getStringExtra("type")

        Glide.with(ivPreviewImage).load(image).placeholder(R.color.grey).into(ivPreviewImage)
        tvPreviewScreenTitle.setText(title.toString())
        tvPreviewRating.setText(type.toString())
        tvPreviewTime.setText(time.toString())
        tvPreviewYear.setText(date.toString())
        tvPreviewSynposis.setText(summary.toString())



    }

    private fun getDataFromIntent() {



        ivPreviewScreenBackIcon.setOnClickListener(View.OnClickListener {

            val intent = Intent(this,MoviesHomePageActivity::class.java)
            startActivity(intent)
        })

    }
}