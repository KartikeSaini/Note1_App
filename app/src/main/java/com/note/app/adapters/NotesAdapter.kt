package com.note.app.adapters

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import com.note.app.R
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.note.app.fragments.ShowNoteFragment
import com.note.app.pojo.Note

//class NotesAdapter(
//    val context: Context,
//    val list: ArrayList<Note>,
//    val fragmentManager: FragmentManager
//) :
//    RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {
//
//
//    inner class NotesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val titleText: TextView = itemView.findViewById(R.id.note_title)
//
//        //  val contentText: TextView = itemView.findViewById(R.id.content_Home)
//        val deleteText: ImageButton = itemView.findViewById(R.id.deleteText)
//        val group: CardView = itemView.findViewById(R.id.inflate_note)
//    }
//
//
//    override fun onCreateViewHolder(
//        parent: ViewGroup,
//        viewType: Int
//    ): NotesViewHolder {
//        val view =
//            LayoutInflater.from(parent.context).inflate(R.layout.inflate_custom_view, parent, false)
//        return NotesViewHolder(view)
//    }
//
//    override fun onBindViewHolder(
//        holder: NotesViewHolder,
//        position: Int
//    ) {
//        holder.titleText.text = list[position].title
//        holder.group.setOnClickListener {
//            val showNoteFragment = ShowNoteFragment()
//            val bundle = Bundle().apply {
//                putString("title", list[position].title)
//                putString("content", list[position].content)
//            }
//            showNoteFragment.arguments = bundle
//            fragmentManager.beginTransaction().replace(R.id.fragment_container, showNoteFragment)
//                .addToBackStack(null).commit()
//        }
//
//        holder.group.setOnLongClickListener(object : View.OnLongClickListener{
//            override fun onLongClick(v: View?): Boolean {
//                holder.group.setCardBackgroundColor(context.getColor(R.color.red))
//                holder.deleteText.visibility = View.VISIBLE
//                return true
//            }
//        })
////
////        holder.deleteText.setOnClickListener {
////            //
////        }
//    }
//
//    override fun getItemCount(): Int = list.size
//
//}

class NotesAdapter(val context: Context, val options: FirebaseRecyclerOptions<Note>) : FirebaseRecyclerAdapter<Note, NotesAdapter.NotesViewHolder>(options){


    var callback : ((Note, NotesViewHolder)->Unit)? = null

    inner class NotesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleText: TextView = itemView.findViewById(R.id.note_title)
        val deleteText: ImageButton = itemView.findViewById(R.id.deleteText)
        val group: CardView = itemView.findViewById(R.id.inflate_note)
    }

    override fun onBindViewHolder(
        holder: NotesViewHolder,
        position: Int,
        model: Note
    ) {

        callback?.invoke(model, holder)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NotesViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.inflate_custom_view, parent, false)
        return NotesViewHolder(view)
    }


}

