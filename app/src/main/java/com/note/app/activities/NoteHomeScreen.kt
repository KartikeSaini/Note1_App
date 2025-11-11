package com.note.app.activities

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.FirebaseDatabase
import com.note.app.R
import com.note.app.adapters.NotesAdapter
import com.note.app.databinding.ActivityNoteHomeScreenBinding
import com.note.app.fragments.EditorFragment
import com.note.app.fragments.SearchScreenFragment
import com.note.app.fragments.ShowNoteFragment
import com.note.app.pojo.Note

class NoteHomeScreen : AppCompatActivity() {
    private lateinit var binding: ActivityNoteHomeScreenBinding
    private lateinit var firebaseDatabase: FirebaseDatabase
    private lateinit var notesAdapter : NotesAdapter

    private val colorList = arrayOf(R.color.purple_200, R.color.ligth_blue, R.color.ligth_levander, R.color.ligth_blue, R.color.ligth_green, R.color.ligth_yellow, R.color.ligth_oranger)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityNoteHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseDatabase = FirebaseDatabase.getInstance().apply {
            setPersistenceEnabled(true)
        }

        binding.imgSearch.setOnClickListener {
            binding.fragmentContainer.visibility = View.VISIBLE
            binding.innerNoteContainer.visibility = View.GONE
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, SearchScreenFragment()).addToBackStack(null)
                .commit()

        }

        binding.addNote.setOnClickListener {
            binding.innerNoteContainer.visibility = View.GONE
            binding.fragmentContainer.visibility = View.VISIBLE
            supportFragmentManager.beginTransaction().replace(
                R.id.fragment_container,
                EditorFragment()
            ).addToBackStack(null).commit()

        }

        val query = firebaseDatabase.getReference("notes").orderByKey()
        val options = FirebaseRecyclerOptions.Builder<Note>().setQuery(query, Note::class.java).setLifecycleOwner(this).build()

        notesAdapter = NotesAdapter(this@NoteHomeScreen,options)
        notesAdapter.callback = {model , holder ->
            holder.titleText.text = model.title
            val bgColor = colorList.random()
            holder.group.setCardBackgroundColor(getColor(bgColor))

            holder.group.setOnClickListener {
                // shownowfragment
                val showNoteFragment = ShowNoteFragment()
                val bundle = Bundle().apply {
                    putString("title", model.title)
                    putString("content", model.content)
                    putString("id", model.id)
                }

                showNoteFragment.arguments = bundle
                binding.fragmentContainer.visibility = View.VISIBLE
                binding.innerNoteContainer.visibility = View.GONE
              supportFragmentManager.beginTransaction().replace(R.id.fragment_container, showNoteFragment).addToBackStack(null).commit()
            }
        }
        val linearLayout = LinearLayoutManager(this@NoteHomeScreen, LinearLayoutManager.VERTICAL, false)
        binding.notesList.apply {
            adapter = notesAdapter
            layoutManager = linearLayout
        }

    }


    override fun onStart() {
        super.onStart()
//        notesAdapter.startListening()
        onBackPressedDispatcher.addCallback(object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val fm = supportFragmentManager

                if (fm.backStackEntryCount > 0) {
                    fm.popBackStack()
                } else {
                    finish()
                }
                if (fm.backStackEntryCount == 1) {
                    binding.innerNoteContainer.visibility = View.VISIBLE
                    binding.fragmentContainer.visibility = View.GONE
                }
            }
        })
    }

    override fun onStop() {
        super.onStop()
//        notesAdapter.stopListening()
    }

}