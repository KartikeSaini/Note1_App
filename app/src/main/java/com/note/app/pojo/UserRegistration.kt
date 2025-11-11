package com.note.app.pojo

data class UserRegistration(val username: String
, val emailId : String, val contact : String, private val password : String){

    fun getPassword():String = password
}
