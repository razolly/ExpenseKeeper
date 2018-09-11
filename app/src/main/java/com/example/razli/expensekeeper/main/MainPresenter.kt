package com.example.razli.expensekeeper.main

class MainPresenter(val view: MainContract.View) : MainContract.Presenter {

    // initialize repo?

    init {
        view.presenter = this
    }

    override fun start() {

    }

    override fun loadArticles() {

    }
}