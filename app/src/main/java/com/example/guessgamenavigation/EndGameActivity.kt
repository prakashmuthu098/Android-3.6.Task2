package com.example.guessgamenavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class EndGameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end_game)

        val num=intent.getStringExtra("number")
        findViewById<TextView>(R.id.correctNum).text=num
    }
}