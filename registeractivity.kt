package com.example.sanjeevkumar.corona1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_registeractivity.*

class registeractivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registeractivity)
        submitbtn.setOnClickListener {
savehero()
        }

        viewdata.setOnClickListener {
            var intent=Intent(this,Displayingactivity::class.java)
            startActivity(intent)
        }
//        checkbutton.setOnClickListener {
//            var intent=Intent(this,Winner::class.java)
//            startActivity(intent)
//        }
    }
    private fun savehero(){
        val name=username.text.toString().trim()
        val nametwo=Username.text.toString().trim()
        val collegename=college.text.toString().trim()
        val glink=glink.text.toString().trim()
        val glinktwo=glinktwo.text.toString().trim()

        if(name.isEmpty()) {
            username.error = "PLEASE ENTER THE NAME"
            return
        }
        if (nametwo.isEmpty()) {
            Username.error = "PLEASE ENTER THE NAME"
            return
        }
        if(collegename.isEmpty()){
            college.error ="PLEASE ENTER THE COLLEGE NAME"
            return
        }

        val ref=FirebaseDatabase.getInstance().getReference("heroes")
        val heroid=ref.push().key
        val hero=Hero(heroid,name,nametwo,collegename,glink,glinktwo)
        ref.child(heroid).setValue(hero).addOnCompleteListener {
            Toast.makeText(this,"Value inserted ",Toast.LENGTH_LONG).show()
        }
    }
}
