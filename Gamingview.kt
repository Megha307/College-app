package com.example.sanjeevkumar.corona1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_treasureview.*

class Gamingview : AppCompatActivity() {
    lateinit var ref: DatabaseReference
    lateinit var gaminglist:MutableList<Game>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gamingview)

        gaminglist= mutableListOf()
        ref= FirebaseDatabase.getInstance().getReference("games")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataChange(p0: DataSnapshot?) {
                if (p0!!.exists()) {

                    gaminglist.clear()

                    for (p in p0.children) {
                        val game = p.getValue(Game::class.java)
                        gaminglist.add(game!!)
                    }


                    val Adapter = GameAdapter(this@Gamingview, R.layout.heros, gaminglist)
                    listview.adapter = Adapter
                }
            }

        })
    }
}


