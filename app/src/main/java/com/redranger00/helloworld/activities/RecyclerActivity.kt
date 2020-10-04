package com.redranger00.helloworld.activities

import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.redranger00.helloworld.adapters.ItemsAdapter
import com.redranger00.helloworld.R
import com.redranger00.helloworld.models.Supplier
import kotlinx.android.synthetic.main.activity_recycler.*

class RecyclerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        title="Tasks"
        val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        setupRecyclerView(clipboard)
    }

    private fun setupRecyclerView(clipboard:ClipboardManager) {

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager

        val adapter = ItemsAdapter(this, Supplier.hobbies,clipboard)
        recyclerView.adapter = adapter
    }
}
