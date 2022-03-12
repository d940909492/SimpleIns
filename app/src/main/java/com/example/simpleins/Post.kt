package com.example.simpleins

import com.parse.ParseClassName
import com.parse.ParseFile
import com.parse.ParseObject
import com.parse.ParseUser

@ParseClassName("Post")
class Post : ParseObject() {

    fun getDescrption(): String? {
        return getString(Key_Descrption)
    }

    fun setDescrption(description : String){
        put(Key_Descrption, description)
    }

    fun getImage(): ParseFile? {
        return getParseFile(Key_Image)
    }

    fun setImage (Parsefile : ParseFile){
        put(Key_Image, Parsefile)
    }

    fun getUser(): ParseUser? {
        return getParseUser(Key_User)
    }
    fun setUser(user: ParseUser){
        put(Key_User,user)
    }

    companion object{
        const val Key_Descrption = "descrption"
        const val Key_Image = "image"
        const val Key_User = "user"
    }
}