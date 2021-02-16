package com.demo.foodapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Cart : AppCompatActivity(){

    lateinit var rvList: RecyclerView
    private var adapter: CartAdapter? = null

    private val list: ArrayList<CartModel> = ArrayList()
    var cartModel: CartModel = CartModel("Vegeterian", "Mix,ff,ff","$23.50")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        rvList = findViewById(R.id.rv_food)

        list.add(cartModel)
        cartModel =CartModel("Vegeterian", "Midffff,ff","$43.50")
        list.add(cartModel)

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = RecyclerView.VERTICAL
        rvList.layoutManager = layoutManager
        rvList.setHasFixedSize(true)

        adapter = CartAdapter(list)
        rvList.adapter = adapter


    }
}