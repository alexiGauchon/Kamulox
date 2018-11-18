package com.example.maine.k_moulox.tool

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.example.maine.k_moulox.R

fun AppCompatActivity.replace(frag: Fragment) {
    supportFragmentManager.beginTransaction().replace(R.id.frame, frag).commit()
}