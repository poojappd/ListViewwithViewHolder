package com.example.listviewwithviewholder

import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(val context: Context, val people:MutableList<Person>) :BaseAdapter() {

    val inputTextMap = mutableMapOf<Int, String>()
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

    override fun getView(index: Int, view: View?, container: ViewGroup?): View? {
        val personViewHolder:PersonViewHolder
        val view1:View?
        if(view==null){
            view1 = layoutInflater.inflate(R.layout.layout_person_row_item, container, false)
            personViewHolder = PersonViewHolder(view1)
            view1.tag = personViewHolder

        }

        else{
            view1 = view
            personViewHolder = view1.tag as PersonViewHolder
        }

        val person = people?.get(index)

        personViewHolder.textViewName.setText(person?.name)
        personViewHolder.textViewLastName.setText(person?.lastName)
        personViewHolder.textViewNationality.setText(person?.nationality)
        personViewHolder.textViewGender.text =
            if (person?.gender === Gender.MALE) "Male" else "Female"
        val inputText = personViewHolder.inputText.text.toString()
        if(inputText!="") {
            inputTextMap[index] =inputText
        }

        return view1
    }

    class PersonViewHolder(view:View){
        val textViewName : TextView
        val textViewLastName: TextView
        val textViewGender : TextView
        val textViewNationality: TextView
        val inputText:EditText

        init {

            inputText = view.findViewById(R.id.InputText)
            inputText.setOnFocusChangeListener { v, b ->
                Log.e(TAG,"Value: ${inputText.text}")
            }
            textViewName = view.findViewById(R.id.textViewName);

            textViewLastName = view.findViewById (R.id.textViewLastName);
            textViewGender =  view.findViewById (R.id.textViewGender);
            textViewNationality = view.findViewById (R.id.textViewNationality);
        }
    }
}