package com.taingy.foodiepal.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.taingy.foodiepal.R
import com.taingy.foodiepal.databinding.FragmentContactBinding

class ContactFragment : Fragment(R.layout.fragment_contact) {
    private lateinit var binding: FragmentContactBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentContactBinding.inflate(layoutInflater)

        binding.btCall.setOnClickListener {
            val callIntent = Intent().apply {
                action = Intent.ACTION_DIAL
            }
            startActivity(callIntent)
        }

        binding.btEmail.setOnClickListener {
            val callIntent = Intent().apply {
                action = Intent.ACTION_SEND
            }
            startActivity(callIntent)
        }
    }
}