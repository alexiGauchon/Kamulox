package com.example.maine.k_moulox

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.toast


class AnkoActivity: AppCompatActivity(), AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_anko)
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
    fun ankoToaster (){
        toast(R.string.app_name)
    }
}