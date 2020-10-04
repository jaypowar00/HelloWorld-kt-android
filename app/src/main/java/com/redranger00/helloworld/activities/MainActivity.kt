package com.redranger00.helloworld.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.redranger00.helloworld.R
import com.redranger00.helloworld.showToast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title="RedRanger"
        setContentView(R.layout.activity_main)
        btnShowToast.setOnClickListener {
            Log.i("MainActivity","Button was clicked")
            showToast("You clicked somethin'")
        }
        btnSubmit.setOnClickListener {
            var data : String = inputTextData.text.toString()
            if (data.isNotEmpty())
                showToast("${data.toUpperCase()}")
            else
                showToast("Submit Clicked !")
            val intent = Intent(this, NewActivity::class.java)
            intent.putExtra("user_data",data)
            startActivity(intent)
        }
        btnRecyclerView.setOnClickListener {
            val intent = Intent(this, RecyclerActivity::class.java)
            startActivity(intent)
        }
    }
}