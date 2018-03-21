package com.example.sanjeevkumar.corona1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_displayingactivity.*
import kotlinx.android.synthetic.main.activity_menuactivity.*

class Displayingactivity : AppCompatActivity() {
lateinit var ref: DatabaseReference
    lateinit var herolist:MutableList<Hero>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_displayingactivity)
herolist= mutableListOf()


         ref= FirebaseDatabase.getInstance().getReference("heroes")


        ref.addValueEventListener(object :ValueEventListener{
            override fun onCancelled(p0: DatabaseError?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataChange(p0: DataSnapshot?) {
           if (p0!!.exists()){
               herolist.clear()

               for (h in p0.children){
                   val hero=h.getValue(Hero::class.java)
                   herolist.add(hero!!)
               }

               val Adapter=HeroAdapter(this@Displayingactivity,R.layout.heros,herolist)

               listview.adapter=Adapter
           }
            }

        })
    }
}
