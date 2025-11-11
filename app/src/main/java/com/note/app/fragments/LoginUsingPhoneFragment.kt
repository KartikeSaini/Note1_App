package com.note.app.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.note.app.R
import com.note.app.databinding.FragmentLoginBinding
import com.note.app.databinding.FragmentLoginUsingPhoneBinding


class LoginUsingPhoneFragment : Fragment() {

    private var _binding: FragmentLoginUsingPhoneBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_login_using_phone, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentLoginUsingPhoneBinding.bind(view)
        var binding : FragmentLoginUsingPhoneBinding = _binding!!
        binding.backBtn2.setOnClickListener {
            requireActivity().onBackPressed()
        }

        binding.proceedBtn.setOnClickListener{
            val contactNo = fetchPhoneNumber(binding)

            if (contactNo != null){
                // login with otp

            }
        }

    }

    private fun fetchPhoneNumber(binding: FragmentLoginUsingPhoneBinding):String?{

        val contactNo = binding.userContact.text.toString().trim()

        if (contactNo.isEmpty()){
            binding.userContact.error = "Please provide contact number"
            return null
        } else if (!contactNo.matches(Regex("\\d{10}")) && contactNo.length < 10){
            binding.userContact.error = "Contact no. should be at least 10 digit or 0-9"
            return null
        }
        return contactNo
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}