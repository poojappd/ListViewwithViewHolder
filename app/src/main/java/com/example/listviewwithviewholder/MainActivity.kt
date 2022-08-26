package com.example.listviewwithviewholder

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    lateinit var  appUtility:AppUtility
    lateinit var listAdapter: ListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        appUtility = AppUtility(this)
        val listView = findViewById<ListView>(R.id.lv)
        listAdapter = ListAdapter(this, appUtility.people)
        listView.adapter = listAdapter
    }

    fun buttonOnClick(view: View){
        Log.e(TAG, "----------------------")
        listAdapter.inputTextMap.forEach{
            Log.e(TAG, it.toString())
        }
        Log.e(TAG, "----------------------")
    }

}