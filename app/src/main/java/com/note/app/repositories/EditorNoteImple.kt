package com.note.app.repositories

import android.content.Context
import android.util.Log
import com.google.firebase.database.FirebaseDatabase
import com.note.app.pojo.Note

class EditorNoteImple(val context: Context, val db: FirebaseDatabase) : EditorNoteRepository {

    val ref = db.getReference("notes")


    override fun submitNote(note: Note) {
        val key = ref.push().key.toString()
        note.id = key
        ref.child(note.id!!).setValue(note).addOnSuccessListener {
            Log.d("NOTE ADD NEW SUCCESS", note.id!!)
        }.addOnFailureListener {
            Log.d("NOTE ADD NEW FAILURE", note.id!!)
        }
    }

    override fun updateNote(noteItem: Note) {
        val updateNote = hashMapOf<String, Any>(
            "title" to noteItem.title,
            "content" to noteItem.content,
            "id" to noteItem.id!!
        )
        ref.child(noteItem.id!!).updateChildren(updateNote).addOnSuccessListener {
            Log.d("NOTE UPDATE SUCCESS", noteItem.id!!)
        }.addOnFailureListener {
            Log.d("NOTE UPDATE FAILURE", noteItem.id!!)
        }
    }

//    fun getNoteList(){
//
//        ref.addValueEventListener(object: ValueEventListener{
//            override fun onDataChange(snapshot: DataSnapshot) {
//                val notes = snapshot.children
//                val list1 = mutableListOf<Note>()
//
//                for(item in notes){
//                    val note = item.getValue(Note::class.java)
//                    list1.add(note!!)
//                }
//                list = list1
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//
//            }
//        })
//        return
//    }

}

