package com.note.app.pojo

class Note {
    var title : String = ""
     var content : String = ""

    var id : String? = null

    constructor(){

    }


    constructor(title:String, content : String){
        this.content = content
        this.title = title
    }

    override fun toString(): String {
        return "Note(title='$title', content='$content')"
    }


}