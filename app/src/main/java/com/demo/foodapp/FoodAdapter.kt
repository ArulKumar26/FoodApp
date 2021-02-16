package com.demo.foodapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.demo.foodapp.databinding.RowFoodBinding
import kotlin.collections.ArrayList

class FoodAdapter(private val items: ArrayList<ProfileModel>) :
    RecyclerView.Adapter<FoodAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: RowFoodBinding =
            RowFoodBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        holder.binding.lblStatus.text = items[position].name
        holder.binding.lblStatus2.text = items[position].name2

    }

    class ViewHolder(val binding: RowFoodBinding) : RecyclerView.ViewHolder(binding.root) {

    }


}