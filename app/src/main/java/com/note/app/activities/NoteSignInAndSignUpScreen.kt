package com.note.app.activities

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.note.app.R
import com.note.app.databinding.ActivityNoteSignInAndSignUpScreenBinding
import com.note.app.fragments.LoginFragment
import com.note.app.fragments.LoginUsingPhoneFragment

class NoteSignInAndSignUpScreen : AppCompatActivity() {

    private lateinit var binding: ActivityNoteSignInAndSignUpScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityNoteSignInAndSignUpScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.loginBtn.setOnClickListener {
            binding.signBox.visibility = View.GONE
            binding.fragmentContainerSign.visibility = View.VISIBLE
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_sign, LoginFragment()).addToBackStack(null)
                .commit()
        }

        binding.phoneBtn.setOnClickListener {
            binding.signBox.visibility = View.GONE
            binding.fragmentContainerSign.visibility = View.VISIBLE
            supportFragmentManager.beginTransaction().replace(
                R.id.fragment_container_sign,
                LoginUsingPhoneFragment()
            ).addToBackStack(null).commit()


        }
    }

    override fun onStart() {
        super.onStart()
        onBackPressedDispatcher.addCallback(object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val fm = supportFragmentManager

                if (fm.backStackEntryCount > 0) {
                    fm.popBackStack()
                } else {
                    finish()
                }
                if (fm.backStackEntryCount == 1) {
                    binding.signBox.visibility = View.VISIBLE
                    binding.fragmentContainerSign.visibility = View.GONE
                }
            }
        })
    }





}