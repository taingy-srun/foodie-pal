package com.taingy.foodiepal.ui.mealplanner

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.taingy.foodiepal.R


class MealPlannerAdapter(private val planners: List<MealPlanner>) : RecyclerView.Adapter<MealPlannerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_planner, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return planners.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val planner = planners[position]

        holder.day.text = planner.day
        holder.breakfast.text = "Breakfast: ${planner.breakfast}"
        holder.lunch.text = "Lunch: ${planner.lunch}"
        holder.dinner.text = "Dinner: ${planner.dinner}"
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val day: TextView = itemView.findViewById(R.id.tv_day)
        val breakfast: TextView = itemView.findViewById(R.id.tv_breakfast)
        val lunch: TextView = itemView.findViewById(R.id.tv_lunch)
        val dinner: TextView = itemView.findViewById(R.id.tv_dinner)
    }
}