package com.taingy.foodiepal.ui.contact

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.taingy.foodiepal.R

class ContactFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_contact, container, false)

        val btCall: Button = view.findViewById(R.id.bt_call)
        btCall.setOnClickListener {
            val phoneNumber = "tel:6412339343"
            val dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse(phoneNumber))
            startActivity(dialIntent)
        }

        val btEmail: Button = view.findViewById(R.id.bt_email)
        btEmail.setOnClickListener {
            val recipient = "taingy.srun20@gmail.com"
            val subject = "Feedback on Recipes"

            val emailIntent = Intent(Intent.ACTION_SEND)
            emailIntent.type = "text/plain"
            emailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(recipient))
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject)

            startActivity(emailIntent)
        }

        return view
    }

}