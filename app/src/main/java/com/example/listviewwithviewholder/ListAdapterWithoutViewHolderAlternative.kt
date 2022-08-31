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

class ListAdapterWithoutViewHolderAlternative (val context: Context, val people:MutableList<Person>):
    BaseAdapter() {

    lateinit var person:Person
    lateinit var textViewName: TextView
    lateinit var textViewLastName: TextView
    lateinit var textViewGender : TextView
    lateinit var textViewNationality: TextView
    val layoutInflater = LayoutInflater.from(context)


    /*
    this method is to be called only once, which signifies the work of a constructor.
    if this method is not invoked, we will get nullPointerException, which again enforces this method to be called
    Hence we use an innerclass as a viewHolder to hold reference of views
    */

    fun viewHolderInitializer(newView : View){
        textViewName = newView.findViewById(R.id.textViewName);
        textViewLastName = newView.findViewById (R.id.textViewLastName);

        textViewGender  = newView.findViewById (R.id.textViewGender);
        textViewNationality = newView.findViewById (R.id.textViewNationality);

    }


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
        var newView: View

        if(view != null) {
            newView = view
        }
        else{
            newView = layoutInflater.inflate(R.layout.layout_person_row_item, viewGroup, false)
        }

        viewHolderInitializer(newView)

        //data binding
        person = people.get(index)
        //using newView since view might be null

        textViewName.setText(person.name)
        textViewLastName.setText(person.lastName)
        textViewNationality.setText(person.nationality)
        textViewGender.text =
            if (person.gender === Gender.MALE) "Male" else "Female"

        val inputText: EditText? = newView?.findViewById(R.id.InputText)
        inputText?.setOnFocusChangeListener { v, b ->
            Log.e(ContentValues.TAG,"Value: ${inputText.text}")
        }
        Log.e(ContentValues.TAG, "getView called $index ${textViewName?.text}")
        return newView



    }
}