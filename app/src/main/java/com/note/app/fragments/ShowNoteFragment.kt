package com.note.app.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.note.app.R
import com.note.app.databinding.FragmentShowNoteBinding


class ShowNoteFragment : Fragment() {

    private var _binding : FragmentShowNoteBinding? = null
    var id : String? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_show_note, container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentShowNoteBinding.bind(view)
        val binding = _binding!!

        arguments.let {
            val title = it?.getString("title")
            val content = it?.getString("content")
            id = it?.getString("id")
            Log.d("SHOW NOTE FRAG", id!!)
            binding.sampleScreentitleTV.text = title
            binding.sampleScreenContentTV.text = content
        }


        binding.backBTN.setOnClickListener {
            requireActivity().onBackPressed()
        }


        binding.editBtn.setOnClickListener {
            val title = binding.sampleScreentitleTV.text.toString()
            val content = binding.sampleScreenContentTV.text.toString()
            val noteBundle = Bundle()
            noteBundle.putString("title", title)
            noteBundle.putString("content", content)
            noteBundle.putString("id", id)
            if (noteBundle != null){
                parentFragmentManager.beginTransaction().replace(R.id.fragment_container,
                    EditorFragment().apply { arguments = noteBundle }).commit()

            }
        }



    }
}