package com.note.app.fragments

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import com.note.app.R
import com.note.app.activities.NoteHomeScreen
import com.note.app.databinding.FragmentLoginBinding



class LoginFragment : Fragment() {
    private var _binding : FragmentLoginBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding: FragmentLoginBinding = _binding!!

        binding.backBtn.setOnClickListener {
           requireActivity().onBackPressed()
        }

        binding.newSignUp.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.fragment_container_sign,
                RegisterFragment()).addToBackStack(null).commit()
        }


        binding.loginBtn.setOnClickListener {

//            val validUser = fetchEmailAndPassword(binding)
//
//            if (validUser != null){
                // authenticate login credential to firebase
                val isAuth = true
                if (isAuth){
                    startActivity(Intent(requireContext(), NoteHomeScreen::class.java))
                    requireActivity().finish()
                } else {
                    Toast.makeText(requireActivity(), "Email and Password didn't matched", Toast.LENGTH_LONG).show()
                }
//            }

        }

    }

    private fun fetchEmailAndPassword(binding: FragmentLoginBinding) : Array<String>?{
        val emailId = binding.userEmail.text.toString().trim()
        val password = binding.userPassword.text.toString().trim()

        if (emailId.isEmpty()){
            binding.userEmail.error = "Invalid email-id"
            return null
        }else if(!Patterns.EMAIL_ADDRESS.matcher(emailId).matches()){
            binding.userEmail.error = "Email id should be a-z,0-9,.@domain.com"
            return null
        }

        if (password.isEmpty()){
            binding.userPassword.error = "Invalid password"
            return null
        }else if(!password.matches(Regex("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\\$%^&*()-__+=\\\\])(?=\\S+$).{8,20}$")) && password.length < 8){
            binding.userPassword.error = "Password should be more than 8 chars a-z,A-Z,0-9,@,#"
            return null
        }

        return arrayOf(emailId, password)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}