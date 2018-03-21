package com.example.sanjeevkumar.corona1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

/**
 * Created by Sanjeev Kumar on 3/4/2018.
 */
class GameAdapter (val mctx: Context, val layoutResId:Int, val gamelist:List<Game>)
    : ArrayAdapter<Game>(mctx,layoutResId,gamelist){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val LayoutInflater: LayoutInflater = LayoutInflater.from(mctx)
        val view: View =LayoutInflater.inflate(layoutResId,null)
        val mname=view.findViewById<TextView>(R.id.editmemeberone)
        val mtname=view.findViewById<TextView>(R.id.editmembertwo)
        val cname=view.findViewById<TextView>(R.id.editcollege)
        val gonename=view.findViewById<TextView>(R.id.editgone)
        val gtwoname=view.findViewById<TextView>(R.id.editgtwo)
        val mthreename=view.findViewById<TextView>(R.id.editmemthree)
        val glinkthree=view.findViewById<TextView>(R.id.editglinkthree)
        val game=gamelist[position]
        mname.text=game.name
        mtname.text=game.nametwo
        cname.text=game.college
        gonename.text=game.gone
        gtwoname.text=game.gtwo
        mthreename.text=game.namethree
        glinkthree.text=game.gthree


        return view

    }
}