package com.galal.seenapay.ui.home.adapter

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.galal.seenapay.R
import com.galal.seenapay.model.Recipe


class RecipeAdapter(private val items: List<Recipe>) :
    RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    inner class RecipeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.image)
        val title: TextView = view.findViewById(R.id.title)
        val rating: TextView = view.findViewById(R.id.rate)
        val chef: TextView = view.findViewById(R.id.chef)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recipe, parent, false)
        return RecipeViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val item = items[position]
        holder.image.setImageResource(item.imageResId)
        holder.title.text = item.title
        holder.rating.text = item.rating
        holder.chef.text = item.chef

        holder.rating.paintFlags = holder.rating.paintFlags or Paint.UNDERLINE_TEXT_FLAG
        holder.chef.paintFlags = holder.chef.paintFlags or Paint.UNDERLINE_TEXT_FLAG
    }


    override fun getItemCount() = items.size
}
