package com.example.sanjeevkumar.corona1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.RadioGroup
import android.widget.TextView

/**
 * Created by Sanjeev Kumar on 3/3/2018.
 */
class checkAdapter (val mctx: Context, val layoutResId:Int,val checklist:List<check>)
    : ArrayAdapter<check>(mctx,layoutResId,checklist) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val LayoutInflater: LayoutInflater = LayoutInflater.from(mctx)
        val view: View = LayoutInflater.inflate(layoutResId, null)
        val mname = view.findViewById<TextView>(R.id.teamname)
        val group = view.findViewById<RadioGroup>(R.id.teamlevel)
        val check = checklist[position]
        mname.text = check.name
        return view
    }
}