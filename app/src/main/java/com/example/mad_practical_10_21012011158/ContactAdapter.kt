package com.example.mad_practical_10_21012011158

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import java.text.FieldPosition

class ContactAdapter( context : Context, val array: ArrayList<Contact>) : ArrayAdapter<Contact>(context,0,array){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_item,parent,false)
        view.findViewById<TextView>(R.id.person_name).text = array.get(position).name
        view.findViewById<TextView>(R.id.phn_no).text = array.get(position).phoneNo
        view.findViewById<TextView>(R.id.email).text = array.get(position).emailId
        view.findViewById<TextView>(R.id.address).text = array.get(position).address

        val locationButton : Button = view.findViewById(R.id.location)

        locationButton.setOnClickListener(){
            val intent =  Intent(context,MapsActivity::class.java)
            context.startActivity(intent)
        }
        return view


//        return super.getView(position, convertView, parent)
    }
}