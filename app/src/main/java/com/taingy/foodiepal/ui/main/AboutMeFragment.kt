package com.taingy.foodiepal.ui.main

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.taingy.foodiepal.R

class AboutMeFragment : Fragment() {
    private val list = mutableListOf("Burger", "Pizza")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_about_me, container, false)
        val listView = view.findViewById<ListView>(R.id.list_view)
        val adapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1, list)
        listView.adapter = adapter

        val fab = view.findViewById<FloatingActionButton>(R.id.fab_add)
        fab.setOnClickListener {
            showInputDialog(requireContext())
        }
        return view
    }

    private fun showInputDialog(context: Context) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Adding new favorite food:")

        val input = EditText(context)
        builder.setView(input)

        builder.setPositiveButton("OK") { _, _ ->
            val food = input.text.toString()
            list.add(food)
        }
        builder.setNegativeButton("Cancel") { dialog, _ -> dialog.cancel() }
        builder.show()
    }

}