package com.example.newsapp

import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.newsapp.data.DataNews

fun initNewsHeadline(context : Context, view : View, position : Int) {

    val imageNewsHeadline : ImageView = view.findViewById(R.id.img_headline)
    val titleNewsHeadline : TextView = view.findViewById(R.id.tv_headline)
    val descNewsHeadline : TextView = view.findViewById(R.id.tv_headline_desc)
    val authorNewsHeadline : TextView = view.findViewById(R.id.tv_author_headline)
    val dateNewsHeadline : TextView = view.findViewById(R.id.tv_date_headline)



    imageNewsHeadline.setImageResource(DataNews.photoHeadline[position])
    titleNewsHeadline.text = DataNews.titleHeadline[position]
    descNewsHeadline.text = DataNews.contentHeadline[position]
    dateNewsHeadline.text = DataNews.dateHeadline[position]
    authorNewsHeadline.text = DataNews.authorHeadline[position]

    view.setOnClickListener{
        val intent = Intent(context, DetailNewsActivity::class.java)
        intent.putExtra(DetailNewsActivity.EXTRA_DATA_TITLE, DataNews.titleHeadline[position])
        intent.putExtra(DetailNewsActivity.EXTRA_DATA_DATE, DataNews.dateHeadline[position] )
        intent.putExtra(DetailNewsActivity.EXTRA_DATA_AUTHOR,DataNews.authorHeadline[position] )
        intent.putExtra(DetailNewsActivity.EXTRA_DATA_CONTENT, DataNews.contentHeadline[position] )
        intent.putExtra(DetailNewsActivity.EXTRA_DATA_IMAGE, DataNews.photoHeadline[position])
        context.startActivity(intent)
    }
}