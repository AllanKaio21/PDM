package com.example.activity5

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivityB : DebugActivity() {
    private val context: Context get() = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val args = intent.extras
        val name = args?.getString("activity")
        val textView = findViewById<TextView>(R.id.textView)
        textView.text = name

        actionBar?.setDisplayHomeAsUpEnabled(true)

        val btn = findViewById<Button>(R.id.button)

        btn.setOnClickListener {
            val intent = Intent(context, MainActivityC::class.java)
            val params = Bundle()
            params.putString("activity", "Activity C!")
            intent.putExtras(params)
            startActivity(intent)
        }
    }
}