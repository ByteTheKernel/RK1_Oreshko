package com.example.rk_1

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class MyActivity: AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var addButton: Button

    private val adapter = MyAdapter()

    // Ключ для сохранения состояния списка
    private val ITEM_LIST_KEY = "item_list_key"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerview)
        addButton = findViewById(R.id.add_square_button)

        recyclerView.adapter = adapter

        addButton.setOnClickListener {
            adapter.addItems(adapter.itemCount + 1)
        }

        if(savedInstanceState != null) {
            val savedItems = savedInstanceState.getIntegerArrayList(ITEM_LIST_KEY)
            if(savedItems != null){
                adapter.setItems(savedItems)
            }
        }
        else {
            adapter.setItems(listOf(1,2,3,4,5))
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putIntegerArrayList(ITEM_LIST_KEY, ArrayList(adapter.getItems()))
    }
}
