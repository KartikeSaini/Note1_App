package com.note.app.fragments

import android.os.Bundle
import android.util.Log
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.note.app.R
import com.note.app.databinding.FragmentRegisterBinding
import com.note.app.pojo.UserRegistration


class RegisterFragment : Fragment() {

    private var _binding : FragmentRegisterBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentRegisterBinding.bind(view)
        val binding: FragmentRegisterBinding = _binding!!

        binding.backBtn.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.signIn.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.fragment_container_sign,
                LoginFragment()).addToBackStack(null).commit()
        }

        binding.registerBtn.setOnClickListener {

            val user = fetchRegistrationDetail(binding)
            if (user != null){
                // register in firebase

                binding.userName.text.clear()
                binding.emailId.text.clear()
                binding.contactNo.text.clear()
                binding.password.text.clear()
                binding.cnfPassword.text.clear()

                Log.d("user", user.toString())
            }
        }


    }

    private fun fetchRegistrationDetail(binding : FragmentRegisterBinding) : UserRegistration?{
        val userName = binding.userName.text.toString().trim()
        val emailId = binding.emailId.text.toString().trim()
        val contactNo = binding.contactNo.text.toString().trim()
        val password = binding.password.text.toString().trim()
        val cnfPassword = binding.cnfPassword.text.toString().trim()

        // check fields input and return as a user
        // check username
        if (userName.isEmpty()){
            binding.userName.error = "Invalid name"
            return null
        }else if(!userName.matches(Regex("^[a-zA-Z]{3,20}$")) && userName.length < 3){
            binding.userName.error = "Username should be at least 3 - 15 chars"
            return null
        }

        // email validation
        if (emailId.isEmpty()){
            binding.emailId.error = "Invalid email-id"
            return null
        }else if(!Patterns.EMAIL_ADDRESS.matcher(emailId).matches()){
            binding.emailId.error = "Email id should be a-z,0-9,.@domain.com"
            return null
        }

        // for contact no
        if (contactNo.isEmpty()){
            binding.contactNo.error = "Invalid Number"
            return null
        }else if(!contactNo.matches(Regex("\\d{10}"))){
            binding.contactNo.error = "Number should be at least 10 digit"
            return null
        }

        // for password
        if (password.isEmpty()){
            binding.password.error = "Invalid password"
            return null
        }else if(!password.matches(Regex("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\\$%^&*()-__+=\\\\])(?=\\S+$).{8,20}$")) && password.length < 8){
            binding.password.error = "Password should be more than 8 chars a-z,A-Z,0-9,@,#"
            return null
        }
        if (cnfPassword.isEmpty()){
            binding.cnfPassword.error = "Invalid password"
            return null
        }else if(!cnfPassword.matches(Regex("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\\$%^&*()-__+=\\\\])(?=\\S+$).{8,20}$")) && cnfPassword.length < 8){
            binding.cnfPassword.error = "Password should be matched"
            return null
        }
        return if (password == cnfPassword) UserRegistration(username = userName, emailId = emailId, contact = contactNo, password = password) else null
    }

}