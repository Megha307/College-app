package com.example.sanjeevkumar.corona1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

/**
 * Created by Sanjeev Kumar on 3/3/2018.
 */
class TreasureAdapter (val mctx: Context, val layoutResId:Int,val treasurelist:List<Treasure>)
    : ArrayAdapter<Treasure>(mctx,layoutResId,treasurelist){
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
            val treasure=treasurelist[position]
            mname.text=treasure.name
            mtname.text=treasure.nametwo
            cname.text=treasure.college
            gonename.text=treasure.gone
            gtwoname.text=treasure.gtwo
            mthreename.text=treasure.namethree
            glinkthree.text=treasure.gthree


            return view

        }
}