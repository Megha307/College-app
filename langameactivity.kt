package com.example.sanjeevkumar.corona1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_langameactivity.*


class langameactivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_langameactivity)
        btn.setOnClickListener {
            var intent=Intent(this,gamecheck::class.java)
            startActivity(intent)
        }
        buttonsub.setOnClickListener {
            savehero()
        }

        dataview.setOnClickListener {
            var intent= Intent(this,Gamingview::class.java)
            startActivity(intent)
        }


    }
    private fun savehero(){
        val name=tname.text.toString().trim()
        val nametwo=tnametwo.text.toString().trim()
        val namethree=tnamethree.text.toString().trim()
        val collegename=tcollege.text.toString().trim()
        val glink=tglink.text.toString().trim()
        val glinktwo=tglinktwo.text.toString().trim()
        val glinkthree=tglinkthree.text.toString().trim()

        if(name.isEmpty()) {
            tname.error = "PLEASE ENTER THE NAME"
            return
        }
        if (nametwo.isEmpty()) {
            tnametwo.error = "PLEASE ENTER THE NAME"
            return
        }
        if(collegename.isEmpty()){
            tcollege.error ="PLEASE ENTER THE COLLEGE NAME"
            return
        }

        val ref= FirebaseDatabase.getInstance().getReference("games")
        val gameid=ref.push().key

        val game=Game(gameid,name,nametwo,namethree,collegename,glink,glinktwo,glinkthree)
        ref.child(gameid).setValue(game).addOnCompleteListener {
            Toast.makeText(this,"Value inserted ", Toast.LENGTH_LONG).show()
        }
    }
}
