package com.example.guessgamenavigation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private val randomNum= Random.nextInt(from = 1, until = 1000)
    var clickCount=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val guessTextInputView=findViewById<TextInputLayout>(R.id.guess)
        val clickMeButton=findViewById<TextView>(R.id.checkButton)
        val resultDisplayView=findViewById<TextView>(R.id.res)
        clickMeButton.setOnClickListener{
            clickCount++
            if(clickCount<=12) {
                val num = guessTextInputView.editText?.text?.toString()
                var guessNum: Int = Integer.parseInt(num)
                when {
                    randomNum > guessNum -> resultDisplayView.text = "N0 :) My number is bigger "
                    randomNum < guessNum -> resultDisplayView.text = "No :) My number is smaller "
                    else ->{
                        val newScreenIntent=Intent(this,EndGameActivity::class.java)
                        newScreenIntent.putExtra("number",randomNum.toString())
                        startActivity(newScreenIntent)
                    }
                }
            }
            else {
                val newScreenIntent = Intent(this, NewActivity::class.java)
                newScreenIntent.putExtra("number",randomNum.toString())
                startActivity(newScreenIntent)
            }
            }
        }
    }
