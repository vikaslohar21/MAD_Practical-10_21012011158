package com.example.mad_practical_10_21012011158

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val floatingButtton : FloatingActionButton = findViewById(R.id.action_btn)

        floatingButtton.setOnClickListener{
            sendDataToListView()
//            Intent(this,MapsActivity::class.java).apply{startActivity(this)}
        }
    }


    private fun getPersonDetailsFromJson(sJson: String?) {
        val personList = ArrayList<Contact>()
        try {
            val jsonArray = JSONArray(sJson)
            for (i in 0 until jsonArray.length()) {
                val jsonObject = jsonArray[i] as JSONObject
                val person = Contact(jsonObject)
                personList.add(person)
            }
            val personlistview = findViewById<ListView>(R.id.data)
            personlistview.adapter = ContactAdapter(this, personList)
        } catch (ee: JSONException) {
            ee.printStackTrace()
        }
    }
    fun sendDataToListView(){


//        val personListView = findViewById<ListView>(R.id.data)
//        val personList = arrayListOf<Contact>(
//            Contact("01", "Vikas", "+917030700140", "vikaslohar2122@gmail.com", "21/8 Hanuman chowk ,Pali,Rajasthan",405.516, 401.654),
//            Contact( "02", "Alex", "+914963461685", " alex123@gmail.com", "14/3 Junking Street ,VimanNagar , Pune" , 423.158, 365.125),
//            Contact( "03", "Jhonny", "+916484796857", " Jhonny6585@gmail.com", "18/9 Daulat nagar , Borivali, Maharashtra" , 423.158, 365.125),
//            Contact( "04", "Connor", "+916975315486", " Connor1453@gmail.com", "25/6 Vidya Nagar, Baroda,  Gujarat" , 423.158, 365.125),
//            Contact( "05", "Jordan", "+914789324865", " Jordan1422@gmail.com", "45/2 junking Street , Pune" , 423.158, 365.125)
//            )

    CoroutineScope(Dispatchers.IO).launch {
        try {
            val data = HttpRequest().makeServiceCall(
                "https://api.json-generator.com/templates/qjeKFdjkXCdK/data",
                "rbn0rerl1k0d3mcwgw7dva2xuwk780z1hxvyvrb1")
            withContext(Dispatchers.Main) {
                try {
                    if(data != null)
                        runOnUiThread{getPersonDetailsFromJson(data)}
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

//        personListView.adapter = ContactAdapter(this,personList)
    }


}