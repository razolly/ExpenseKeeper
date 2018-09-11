package com.example.razli.expensekeeper

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.razli.expensekeeper.model.Article
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.single_card.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // todo move this later to presenter
        val article1 = Article(1, "A Title", "A description")
        val article2 = Article(1, "A Title", "A description")
        val article3 = Article(1, "A Title", "A description")
        val article4 = Article(1, "A Title", "A description")
        val article5 = Article(1, "A Title", "A description")
        val article6 = Article(1, "A Title", "A description")

        val articleList = ArrayList<Article>().also {
            it.add(article1)
            it.add(article2)
            it.add(article3)
            it.add(article4)
            it.add(article5)
            it.add(article6)
        }

        initRecyclerView(articleList)
    }

    private fun initRecyclerView(articleList: ArrayList<Article>) {
        val adapter = HorizontalAdapter(articleList)
        recyclerview.adapter = adapter
        val layoutManager = GridLayoutManager(this, 1)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        recyclerview.layoutManager = layoutManager

//        recyclerview.layoutManager = LinearLayoutManager(this)
    }
}

class HorizontalAdapter(var articleList: ArrayList<Article>) : RecyclerView.Adapter<HorizontalAdapter.CustomViewHolder>() {

    // Called when RecyclerView needs a new RecyclerView.ViewHolder of the given type to represent an item.
    // This new ViewHolder should be constructed with a new View that can represent the items of the given type.
    // The new ViewHolder will be used to display items of the adapter using onBindViewHolder
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CustomViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.single_card, p0, false)
        return CustomViewHolder(view)
    }

    override fun getItemCount(): Int {
        return articleList.size
    }

    // Called by RecyclerView to display the data at the specified position. This method should
    // update the contents of the itemView to reflect the item at the given position.
    override fun onBindViewHolder(p0: CustomViewHolder, p1: Int) {
        //p0.itemView.image_view
        p0.itemView.title.text = articleList[p1].title
        p0.itemView.description.text = articleList[p1].description
        p0.itemView.published_date.text = articleList[p1].publishDate
    }

    inner class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view)
}