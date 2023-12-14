package com.taingy.foodiepal.ui.recipes

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

class RecipesFragment : Fragment() {

    private val recipes = mutableListOf<Recipes>(
        Recipes("Pizza", "flour, yeast, water, salt, and olive oil."),
        Recipes("Burger", "1 ½ pounds lean ground beef · ½ onion, finely chopped · ½ cup shredded Colby Jack or Cheddar cheese · 1 egg"),
        Recipes("Omelette", "butter, eggs, cheese and salt & pepper.")
    )
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_recipes, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        val adapter = RecipesAdapter(recipes)
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
        titleEditText.hint = "Recipe name"
        val descriptionEditText: EditText = dialogView.findViewById(R.id.descriptionEditText)
        descriptionEditText.hint = "Ingredient..."

        builder.setTitle("Add New Recipe")
        builder.setPositiveButton("Save") { _, _ ->
            val name = titleEditText.text.toString()
            val ingredient = descriptionEditText.text.toString()
            val recipe = Recipes(name, ingredient)

            recipes.add(recipe)
        }

        builder.setNegativeButton("Cancel") { dialog, _ ->
            dialog.cancel()
        }

        val alertDialog = builder.create()
        alertDialog.show()
    }
}