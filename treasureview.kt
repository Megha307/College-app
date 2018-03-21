package com.example.sanjeevkumar.corona1

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_treasureview.*
import kotlinx.android.synthetic.main.round.*

class treasureview : AppCompatActivity() {
    lateinit var ref: DatabaseReference
    lateinit var treausrelist:MutableList<Treasure>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_treasureview)
        treausrelist= mutableListOf()


        ref= FirebaseDatabase.getInstance().getReference("treasures")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataChange(p0: DataSnapshot?) {
                if (p0!!.exists()) {
                    treausrelist.clear()
                    for (t in p0.children) {
                        val treasure = t.getValue(Treasure::class.java)
                        treausrelist.add(treasure!!)
                    }


                    val Adapter = TreasureAdapter(this@treasureview, R.layout.heros, treausrelist)
                    listview.adapter = Adapter
                }
            }

})
}
}

