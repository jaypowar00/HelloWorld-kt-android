package com.redranger00.helloworld.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.redranger00.helloworld.R
import kotlinx.android.synthetic.main.activity_new.*

class NewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title="New Activity"
        setContentView(R.layout.activity_new)
        val bundle : Bundle? = intent.extras
        bundle?.let {
            val data = bundle!!.getString("user_data")
            if (data!!.isNotEmpty()){
                dataOutput.text=data
                dataOutputTitle.text="input data:"
            }
        }
    }
}