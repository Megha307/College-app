package com.example.sanjeevkumar.corona1

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.TextView

/**
 * Created by Sanjeev Kumar on 3/3/2018.
 */
class HeroAdapter(val mctx:Context, val layoutResId:Int,val herolist:List<Hero>)
    :ArrayAdapter<Hero>(mctx,layoutResId,herolist)
{
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val LayoutInflater:LayoutInflater= LayoutInflater.from(mctx)
        val view:View=LayoutInflater.inflate(layoutResId,null)
        val mname=view.findViewById<TextView>(R.id.editmemeberone)
        val mtname=view.findViewById<TextView>(R.id.editmembertwo)
        val cname=view.findViewById<TextView>(R.id.editcollege)
        val gonename=view.findViewById<TextView>(R.id.editgone)
        val gtwoname=view.findViewById<TextView>(R.id.editgtwo)
        //val update=view.findViewById<TextView>(R.id.updatetextview)
        val hero=herolist[position]
        mname.text=hero.name
    mtname.text=hero.nametwo
    cname.text=hero.college
        gonename.text=hero.gone
        gtwoname.text=hero.gtwo

       // update.setOnClickListener {
         //   showUpdateDialog()
        //}
        return view

    }
    fun showUpdateDialog()
    {
        val builder=AlertDialog.Builder(mctx)
        val inflater=LayoutInflater.from(mctx)
        val view=inflater.inflate(R.layout.update_layout, null)
        val username=view.findViewById<EditText>(R.id.username)
        builder.setView(view)
        builder.setPositiveButton("Update",object :DialogInterface.OnClickListener{
            override fun onClick(dialog: DialogInterface?, which: Int) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }


        })
        builder.setNegativeButton("NO",object :DialogInterface.OnClickListener{
            override fun onClick(dialog: DialogInterface?, which: Int) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })
        val alert=builder.create()
        alert.show()
    }
}