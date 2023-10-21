package com.example.mad_practical_10_21012011158

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import java.text.FieldPosition

class ContactAdapter(val context : Context, val array: ArrayList<Contact>) : ArrayAdapter<Contact>(context,0,array){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_item,parent)
        return view
        return super.getView(position, convertView, parent)
    }
}