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
    lateinit var slowListAdapter:ListAdapterSlowWay
    lateinit var rightListAdapter: ListAdapterRightWay
    lateinit var alternateAdapter: ListAdapterWithoutViewHolderAlternative

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        appUtility = AppUtility(this)

        val listView = findViewById<ListView>(R.id.lv)
        slowListAdapter = ListAdapterSlowWay(this, appUtility.people)
        rightListAdapter = ListAdapterRightWay(this, appUtility.people)
        alternateAdapter = ListAdapterWithoutViewHolderAlternative(this, appUtility.people)

        listAdapter = ListAdapter(this, appUtility.people)

        //adapter swap here
        listView.adapter = alternateAdapter
    }

    fun buttonOnClick(view: View){
        Log.e(TAG, "----------------------")
        listAdapter.inputTextMap.forEach{
            Log.e(TAG, it.toString())
        }
        Log.e(TAG, "----------------------")
    }

}