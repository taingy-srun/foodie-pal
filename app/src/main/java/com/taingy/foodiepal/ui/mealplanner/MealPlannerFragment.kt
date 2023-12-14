package com.taingy.foodiepal.ui.mealplanner

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.taingy.foodiepal.R


class MealPlannerFragment : Fragment() {

    private val mealPlanners = mutableListOf<MealPlanner>(
        MealPlanner("Monday", "Bread", "Fried Rice", "Noodle"),
        MealPlanner("Tuesday", "Omelette", "Beef Lok Lak", "Sushi"),
        MealPlanner("Wednesday", "Sandwich", "Tonkashi", "Ramen"),
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_meal_planner, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        val adapter = MealPlannerAdapter(mealPlanners)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
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
        val dialogView: View = inflater.inflate(R.layout.custom_alert_dialog_meal_planner, null)
        builder.setView(dialogView)

        val spinner: Spinner = dialogView.findViewById(R.id.spinner)

        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.days_of_week,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        var day: String? = "Not Selected"
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                day = parent.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }

        val etBreakfast: EditText = dialogView.findViewById(R.id.etBreakfast)
        val etLunch: EditText = dialogView.findViewById(R.id.etLunch)
        val etDinner: EditText = dialogView.findViewById(R.id.etDinner)

        builder.setTitle("Add New Meal Planner")
        builder.setPositiveButton("Save") { _, _ ->
            val breakfast = etBreakfast.text.toString()
            val lunch = etLunch.text.toString()
            val dinner = etDinner.text.toString()
            val mealPlanner = MealPlanner(day!!, breakfast, lunch, dinner)

            mealPlanners.add(mealPlanner)
        }

        builder.setNegativeButton("Cancel") { dialog, _ ->
            dialog.cancel()
        }

        val alertDialog = builder.create()
        alertDialog.show()
    }
}