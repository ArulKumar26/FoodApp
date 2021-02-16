package com.demo.foodapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.demo.foodapp.databinding.RowCartBinding
import com.demo.foodapp.databinding.RowFoodBinding

class CartAdapter (private val items: ArrayList<CartModel>) :
RecyclerView.Adapter<CartAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: RowCartBinding =
            RowCartBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        holder.binding.username.text = items[position].name
        holder.binding.spices.text = items[position].spices
        holder.binding.price.text = items[position].amt

    }

    class ViewHolder(val binding: RowCartBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}