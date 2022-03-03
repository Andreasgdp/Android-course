package com.example.display1000int

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CustomAdapter
    private lateinit  var layoutManager: RecyclerView.LayoutManager
    private val numberViewModel: NumberViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.setHasFixedSize(true)

        //layoutManager = LinearLayoutManager(this);
        layoutManager = GridLayoutManager(this, 2)
        recyclerView.layoutManager = layoutManager

        adapter = CustomAdapter()
        adapter.setNumbers(numberViewModel.getNumbers().value!!)
        recyclerView.adapter = adapter

        numberViewModel.getNumbers().observe(this) { numbers ->
            adapter.setNumbers(numbers)
        }

    }
}