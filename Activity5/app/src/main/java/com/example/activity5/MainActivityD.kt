package com.example.activity5

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView

class MainActivityD : DebugActivity() {
    private val context: Context get() = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val args = intent.extras
        val name = args?.getString("activity")
        actionBar?.setDisplayHomeAsUpEnabled(true)

        val textView = findViewById<TextView>(R.id.textView)
        textView.text = name

        val btn = findViewById<Button>(R.id.button)

        btn.setOnClickListener {
            val intent = Intent(context, MainActivityA::class.java)
            val params = Bundle()
            params.putString("activity", "Activity A!")
            intent.putExtras(params)
            startActivity(intent)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item?.itemId == android.R.id.home){
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}