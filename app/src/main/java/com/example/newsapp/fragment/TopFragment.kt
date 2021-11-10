package com.example.newsapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.adapter.NewsAdapter
import com.example.newsapp.R
import com.example.newsapp.data.DataNews
import com.example.newsapp.initNewsHeadline

class TopFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =inflater.inflate(R.layout.fragment_top, container, false)

        val rvTopNews : RecyclerView = view.findViewById(R.id.rv_all_news_top)
        rvTopNews.layoutManager = LinearLayoutManager(view.context)
        rvTopNews.adapter = NewsAdapter(DataNews.dataTopNews)


        val newsHeadline = view.findViewById<View>(R.id.news_headline)
        initNewsHeadline(view.context, newsHeadline, 2)

        return view
    }


}