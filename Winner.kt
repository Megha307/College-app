package com.example.sanjeevkumar.corona1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_displayingactivity.*
import kotlinx.android.synthetic.main.activity_menuactivity.*

class Winner : AppCompatActivity() {
    lateinit var ref: DatabaseReference
    lateinit var checklist:MutableList<check>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_winner)

        checklist= mutableListOf()


            ref= FirebaseDatabase.getInstance().getReference("treasures")

    ref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataChange(p0: DataSnapshot?) {
                if (p0!!.exists()){
                    checklist.clear()

                    for (h in p0.children){
                        val check=h.getValue(check::class.java)
                        checklist.add(check!!)
                    }

                    //Log.i("Winner","Hero List size = ${herolist.size}")

                    val adapter=checkAdapter(this@Winner,R.layout.round,checklist)

                    listview.adapter = adapter
                }
            }

        })
    }
}