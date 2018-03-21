package com.example.sanjeevkumar.corona1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    var uptodown: Animation? = null
    var downtotop:Animation? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        uptodown = AnimationUtils.loadAnimation(this,R.anim.uptodown);
        downtotop = AnimationUtils.loadAnimation(this,R.anim.downtotop);
        l1.setAnimation(uptodown);
        l2.setAnimation(downtotop);

        buttonsub.setOnClickListener {
            var intent= Intent(this,Menuactivity::class.java)
            startActivity(intent)
        }
    }
}
