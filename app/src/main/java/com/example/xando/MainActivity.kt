package com.example.xando

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var player1:EditText = findViewById<EditText>(R.id.player1)
        var player2:EditText = findViewById<EditText>(R.id.player2)
        var start:Button = findViewById<Button>(R.id.play)

        start.setOnClickListener {
            if (player1.text.toString().length == 0) {
                player1.setText("Player 1")
            }
            if (player2.text.toString().length == 0) {
                player2.setText("Player 2")
            }

            var intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("Player 1", player1.text.toString())
            intent.putExtra("Player 2", player2.text.toString())
            startActivity(intent)


        }
    }
}