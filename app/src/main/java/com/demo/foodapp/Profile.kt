package com.demo.foodapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Profile : AppCompatActivity() {

    lateinit var rvList: RecyclerView
    private var adapter: FoodAdapter? = null

    private val list: ArrayList<ProfileModel> = ArrayList()
    var profileModel: ProfileModel = ProfileModel("Vegeterian", "Mix")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        rvList = findViewById(R.id.rv_food)

        list.add(profileModel)
        profileModel = ProfileModel("Mushroom", "Mix")
        list.add(profileModel)

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = RecyclerView.HORIZONTAL
        rvList.layoutManager = layoutManager
        rvList.setHasFixedSize(true)

        adapter = FoodAdapter(list)
        rvList.adapter = adapter

    }

}