package com.example.sanjeevkumar.corona1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_menuactivity.*

class Menuactivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menuactivity)

        Glide.with(this)
                .load(R.drawable.nfs)
                .into(nfs)
        Glide.with(this)
                .load(R.drawable.website)
                .into(uiview)
        Glide.with(this)
                .load(R.drawable.featuredcode)
                .into(tview)
        uiview.setOnClickListener {
            var intent=Intent(this,registeractivity::class.java)
            startActivity(intent)

        }
        uibtn.setOnClickListener {
            var intent=Intent(this,registeractivity::class.java)
            startActivity(intent)
        }
        tview.setOnClickListener {
            var intent=Intent(this,treasurehuntactivity::class.java)
            startActivity(intent)
        }
        treasurebtn.setOnClickListener {
            var intent=Intent(this,treasurehuntactivity::class.java)
            startActivity(intent)
        }
        button.setOnClickListener {
            var intent=Intent(this,langameactivity::class.java)
            startActivity(intent)
        }
        nfs.setOnClickListener {
            var intent=Intent(this,langameactivity::class.java)
            startActivity(intent)
        }

    }
}
