package com.example.razli.expensekeeper.main

import com.example.razli.expensekeeper.model.Article
import com.example.razli.expensekeeper.util.BasePresenter
import com.example.razli.expensekeeper.util.BaseView

interface MainContract {

    interface View : BaseView<Presenter> {

        fun showArticles(articles: ArrayList<Article>)

    }

    interface Presenter : BasePresenter {

        fun loadArticles()

    }
}