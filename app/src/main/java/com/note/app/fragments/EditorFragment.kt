package com.note.app.fragments

import android.app.Dialog
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.database.FirebaseDatabase
import com.note.app.R
import com.note.app.databinding.FragmentEditorBinding
import com.note.app.pojo.Note
import com.note.app.repositories.EditorNoteImple
import com.note.app.repositories.EditorNoteRepository
import com.note.app.viewmodel.NoteViewModel
import com.note.app.viewmodelfactory.NoteViewModelFactory


class EditorFragment : Fragment() {
    private var _binding: FragmentEditorBinding? = null
    private var noteItem : Note = Note()
    val db by lazy {
        FirebaseDatabase.getInstance()
    }

    val viewModel by lazy {
        viewModelSetup()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_editor, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentEditorBinding.bind(view)
        val binding = _binding!!


        arguments?.let {
            noteItem.title = arguments?.getString("title")!!
            noteItem.content = arguments?.getString("content")!!
            noteItem.id = arguments?.getString("id")!!
            binding.editTitle.setText(noteItem.title)
            binding.editContent.setText(noteItem.content)
        }
        binding.backBTN.setOnClickListener {
            showConfirmDialogBox()
        }
        binding.saveBTN.setOnClickListener {
            showCustomDialog(binding)
        }
        handleUi(binding)

    }



    private fun handleUi(binding: FragmentEditorBinding) {

        //  Visibility toggle
        binding.openBTN.setOnClickListener {
            if (binding.editTitle.isFocusable && binding.editContent.isFocusable) {
                setEditFieldFocusable(binding, false)
                binding.openBTN.setImageResource(R.drawable.visibility_off)
            } else {
                setEditFieldFocusable(binding, true)
                binding.openBTN.setImageResource(R.drawable.visibility)
            }
        }

        // Hint clearing on focus
        setupHintBehavior(binding.editTitle, "Title")
        setupHintBehavior(binding.editContent, "Type something...")
    }

    private fun setEditFieldFocusable(binding: FragmentEditorBinding, focusMode: Boolean) {
        binding.editTitle.apply {
            isFocusable = focusMode
            isFocusableInTouchMode = focusMode
            isCursorVisible = focusMode
            isLongClickable = focusMode
            setTextIsSelectable(focusMode)
        }
        binding.editContent.apply {
            isFocusable = focusMode
            isFocusableInTouchMode = focusMode
            isCursorVisible = focusMode
            isLongClickable = focusMode
            setTextIsSelectable(focusMode)
        }
    }


    private fun setupHintBehavior(editText: EditText, hint: String) {
        editText.hint = hint
        editText.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                editText.hint = ""
            } else if (editText.text.isEmpty()) {
                editText.hint = hint
            }
        }
    }

    private fun showCustomDialog(binding: FragmentEditorBinding) {
        val dialog = Dialog(requireContext())
        dialog.setContentView(R.layout.custom_dialog_save)
        dialog.setCancelable(false)
        val saveBtn = dialog.findViewById<Button>(R.id.btnSave)
        val discardBtn = dialog.findViewById<Button>(R.id.btnDiscard)
        saveBtn.setOnClickListener {
            val title = binding.editTitle.text.toString()
            val content = binding.editContent.text.toString()

            if (title.isBlank() && content.isBlank()) {
                Toast.makeText(requireContext(), "Nothing to save", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            } else {
                dialog.dismiss()
                noteItem.title = title
                noteItem.content = content

                // save data into realtime database
                if (noteItem.id.isNullOrEmpty()){
                    viewModel.submitNote(noteItem)

                }else {
                    viewModel.updateNote(noteItem)
                }

                parentFragmentManager.beginTransaction().remove(this).commit()
                requireActivity().onBackPressed()
                Toast.makeText(requireContext(), "Note Saved: $title", Toast.LENGTH_SHORT).show()
            }
        }

        discardBtn.setOnClickListener {
            dialog.dismiss()
            showConfirmDialogBox()
//            Toast.makeText(requireContext(), "Note Discarded", Toast.LENGTH_SHORT).show()
        }

        dialog.show()

    }


    private fun showConfirmDialogBox() {
        val dialog = Dialog(requireContext())
        dialog.setContentView(R.layout.custom_keep_dialog)
        dialog.setCancelable(false)

        val keepButton = dialog.findViewById<Button>(R.id.btnkeep)
        val discardBtn = dialog.findViewById<Button>(R.id.btnDiscardkeep)

        keepButton.setOnClickListener {
            dialog.dismiss()
        }

        discardBtn.setOnClickListener {
            dialog.dismiss()
            parentFragmentManager.beginTransaction().remove(this).commit()
            requireActivity().onBackPressed()
        }

        dialog.show()
    }


    private fun viewModelSetup(): NoteViewModel {
        val repository: EditorNoteRepository = EditorNoteImple(requireContext(), db)
        val factory = NoteViewModelFactory(repository)
        return ViewModelProvider(this, factory)[NoteViewModel::class.java]
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}