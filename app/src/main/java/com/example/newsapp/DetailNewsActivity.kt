package com.example.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.newsapp.data.News

class DetailNewsActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_DATA_TITLE = "title"
        const val EXTRA_DATA_DATE = "date"
        const val EXTRA_DATA_AUTHOR = "author"
        const val EXTRA_DATA_CONTENT = "content"
        const val EXTRA_DATA_IMAGE = "image"
        const val EXTRA_DATA_OBJECT = "news"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_news)
        setSupportActionBar(findViewById(R.id.toolbar_detail))
        supportActionBar?.apply {
            setDisplayShowHomeEnabled(true)
            setDisplayHomeAsUpEnabled(true)
            title= "News Detail"
        }



        val tvTitleDetail = findViewById<TextView>(R.id.tv_title_detail)
        tvTitleDetail.text= intent.getStringExtra("title")

        val tvDateDetail = findViewById<TextView>(R.id.tv_date_detail)
        tvDateDetail.text= intent.getStringExtra("date")

        val tvAuthorDetail = findViewById<TextView>(R.id.tv_author_detail)
        tvAuthorDetail.text = intent.getStringExtra("author")

        val tvContentDetail =  findViewById<TextView>(R.id.tv_content_detail)
        tvContentDetail.text = intent.getStringExtra("content")

        val imgDetail = findViewById<ImageView>(R.id.img_news_detail)
        imgDetail.setImageResource(intent.getIntExtra("image", 0))


        val dataNews = intent.getParcelableExtra<News>(EXTRA_DATA_OBJECT)
        tvTitleDetail.text = dataNews?.title
        tvDateDetail.text = dataNews?.date
        tvAuthorDetail.text = dataNews?.author
        tvContentDetail.text = dataNews?.content
        dataNews?.let { imgDetail.setImageResource(it.photo) }

        if (dataNews != null){
            tvTitleDetail.text = dataNews?.title
            tvDateDetail.text = dataNews?.date
            tvAuthorDetail.text = dataNews?.author
            tvContentDetail.text = dataNews?.content
            dataNews?.let { imgDetail.setImageResource(it.photo) }
        }else{
            tvTitleDetail.text= intent.getStringExtra(EXTRA_DATA_TITLE)
            tvDateDetail.text= intent.getStringExtra(EXTRA_DATA_DATE)
            tvAuthorDetail.text = intent.getStringExtra(EXTRA_DATA_AUTHOR)
            tvContentDetail.text = intent.getStringExtra(EXTRA_DATA_CONTENT)
            imgDetail.setImageResource(intent.getIntExtra(EXTRA_DATA_IMAGE, 0))
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }


}