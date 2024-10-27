package com.example.firstproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView : RecyclerView
    private lateinit var fab : FloatingActionButton
    private val adapter = MyAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        fab = findViewById(R.id.fab)
        recyclerView.adapter = adapter

        if (savedInstanceState != null) {
            val itemList = savedInstanceState.getIntegerArrayList("item_list")
            itemList?.let { adapter.setItems(it) }
        }

        fab.setOnClickListener {
            adapter.addItems(adapter.itemCount + 1)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val itemList = adapter.getItems()
        outState.putIntegerArrayList("item_list", ArrayList(itemList))
    }
}