package com.taingy.foodiepal.ui.blog

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.taingy.foodiepal.R

class BlogFragment : Fragment() {

    private val blogs = mutableListOf<Blog>(
        Blog("Join us for the 2023 Holiday Bucket List!", "We are entering an incredibly tradition-rich, nostalgic, and charming time of year – in my family, most of that is based around the much-anticipated build up to Christmas."),
        Blog("Gnocchi with Creamy Mushroom Sauce", "Delicious pillowy gnocchi swimming in a silky creamy sauce that’s laced with thyme and loaded with little slips of garlic butter-browned mushrooms! Oh, this is so good."),
        Blog("Easy Instant Pot Applesauce", "My go-to method for homemade applesauce! Just apples, water, and cinnamon. A perfect kid recipe for an afternoon snack!"),
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_blog, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        val adapter = BlogAdapter(blogs)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter


        val fab = view.findViewById<FloatingActionButton>(R.id.fab_add)
        fab.setOnClickListener {
            showAlertDialog()
        }
        return view
    }

    private fun showAlertDialog() {
        val builder = AlertDialog.Builder(requireContext())
        val inflater = requireContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val dialogView: View = inflater.inflate(R.layout.custom_alert_dialog, null)
        builder.setView(dialogView)

        val titleEditText: EditText = dialogView.findViewById(R.id.titleEditText)
        val descriptionEditText: EditText = dialogView.findViewById(R.id.descriptionEditText)

        builder.setTitle("Add New Blog")
        builder.setPositiveButton("Save") { _, _ ->
            val title = titleEditText.text.toString()
            val description = descriptionEditText.text.toString()
            val blog = Blog(title, description)

            blogs.add(blog)
        }

        builder.setNegativeButton("Cancel") { dialog, _ ->
            dialog.cancel()
        }

        val alertDialog = builder.create()
        alertDialog.show()
    }
}