package com.example.mad_practical_10_21012011158

import java.io.Serializable

class Contact (var id : String,
    var name : String,
    var phoneNo: Int,
    var emailId : String,
    var address : String,
    var latitude : Double,
    var longitude : Double) : Serializable{
}