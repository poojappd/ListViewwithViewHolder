package com.example.listviewwithviewholder

import android.content.Context

class AppUtility (val context: Context) {
    var names: Array<String>
    var lastnames: Array<String>
    var genders: Array<String>
    var nationalities: Array<String>



     var people: MutableList<Person>

    var appUtility: AppUtility? = null

    init{
        names = context.getResources().getStringArray(R.array.names)
        lastnames = context.getResources().getStringArray(R.array.lastnames)
        genders = context.getResources().getStringArray(R.array.gender)
        nationalities = context.getResources().getStringArray(R.array.nationality)
        people = mutableListOf<Person>()
        for (i in names.indices) {
            val person = Person(
                names[i], lastnames[i],
                if (genders[i].equals(
                        "male",
                        ignoreCase = true
                    )
                ) Gender.MALE else Gender.FEMALE,
                nationalities[i]
            )
            people!!.add(person)
        }
    }




}