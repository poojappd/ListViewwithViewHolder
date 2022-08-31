package com.example.listviewwithviewholder

import android.content.ContentValues
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.EditText
import android.widget.TextView

class ListAdapterRightWay(val context: Context, val people:MutableList<Person>):BaseAdapter() {

    val layoutInflater = LayoutInflater.from(context)


    override fun getCount(): Int {
        return people.size
    }

    override fun getItem(p0: Int): Any {
        return people.get(p0)
    }
    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }



    override fun getView(index: Int, view: View?, viewGroup: ViewGroup?): View? {
        //view creation
        var newView:View? = view
        if(view == null) {
          newView = layoutInflater.inflate(R.layout.layout_person_row_item, viewGroup, false)
        }

        //data binding
        val person = people.get(index)
        //using newView since view might be null
        val textViewName : TextView? = newView?.findViewById(R.id.textViewName);
        val textViewLastName: TextView? = newView?.findViewById (R.id.textViewLastName);
        val textViewGender : TextView? = newView?.findViewById (R.id.textViewGender);
        val textViewNationality: TextView? = newView?.findViewById (R.id.textViewNationality);
        textViewName?.setText(person.name)
        textViewLastName?.setText(person.lastName)
        textViewNationality?.setText(person.nationality)
        textViewGender?.text =
            if (person.gender === Gender.MALE) "Male" else "Female"

        val inputText: EditText? = newView?.findViewById(R.id.InputText)
        inputText?.setOnFocusChangeListener { v, b ->
            Log.e(ContentValues.TAG,"Value: ${inputText.text}")
        }
        Log.e(ContentValues.TAG, "getView called $index ${textViewName?.text}")
        return newView



    }

}