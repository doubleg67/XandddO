package com.example.xando

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.graphics.toColor
import org.w3c.dom.Text

class SecondActivity : AppCompatActivity(), OnClickListener{

    private lateinit var pirveli: Button
    private lateinit var meore: Button
    private lateinit var mesame: Button
    private lateinit var meotxe: Button
    private lateinit var mexute: Button
    private lateinit var meeqvse: Button
    private lateinit var meshvide: Button
    private lateinit var merve: Button
    private lateinit var mecxre: Button
    private lateinit var restarti: Button
    private var qula1 = 0
    private var qula2 = 0
    private var player1 = ""
    private var player2 = ""
    private lateinit var qulebi1:TextView
    private lateinit var qulebi2:TextView
    private var motamashe = 1
    private var firstPlayer = ArrayList<Int>()
    private var secondPlayer = ArrayList<Int>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second2)
        var pl1: TextView = findViewById(R.id.p1)
        var pl2: TextView = findViewById(R.id.p2)

        val intent = getIntent()
        val player11 = intent.getStringExtra("Player 1")
        val player22 = intent.getStringExtra("Player 2")

        player1 = player11.toString()
        player2 = player22.toString()
        pirveli = findViewById(R.id.square1)
        meore = findViewById(R.id.square2)
        mesame = findViewById(R.id.square3)
        meotxe = findViewById(R.id.square4)
        mexute = findViewById(R.id.square5)
        meeqvse = findViewById(R.id.square6)
        meshvide = findViewById(R.id.square7)
        merve = findViewById(R.id.square8)
        mecxre = findViewById(R.id.square9)
        qulebi1 = findViewById<TextView>(R.id.score1)
        qulebi2 = findViewById<TextView>(R.id.score2)
        restarti = findViewById<Button>(R.id.reset)

        pirveli.setOnClickListener(this)
        meore.setOnClickListener(this)
        mesame.setOnClickListener(this)
        meotxe.setOnClickListener(this)
        mexute.setOnClickListener(this)
        meeqvse.setOnClickListener(this)
        meshvide.setOnClickListener(this)
        merve.setOnClickListener(this)
        mecxre.setOnClickListener(this)


        pl1.text = player1.toString()
        pl2.text = player2.toString()




        restarti.setOnClickListener {
            pirveli.text = ""
            meore.text = ""
            mesame.text = ""
            meotxe.text = ""
            mexute.text = ""
            meeqvse.text = ""
            meshvide.text = ""
            merve.text = ""
            mecxre.text = ""
            pirveli.setBackgroundColor(Color.parseColor("#004D40"))
            meore.setBackgroundColor(Color.parseColor("#004D40"))
            mesame.setBackgroundColor(Color.parseColor("#004D40"))
            meotxe.setBackgroundColor(Color.parseColor("#004D40"))
            mexute.setBackgroundColor(Color.parseColor("#004D40"))
            meeqvse.setBackgroundColor(Color.parseColor("#004D40"))
            meshvide.setBackgroundColor(Color.parseColor("#004D40"))
            merve.setBackgroundColor(Color.parseColor("#004D40"))
            mecxre.setBackgroundColor(Color.parseColor("#004D40"))
            pirveli.isEnabled = true
            meore.isEnabled = true
            mesame.isEnabled = true
            meotxe.isEnabled = true
            mexute.isEnabled = true
            meeqvse.isEnabled = true
            meshvide.isEnabled = true
            merve.isEnabled = true
            mecxre.isEnabled = true
            firstPlayer.clear()
            secondPlayer.clear()
        }
    }

   override fun onClick(clickedView: View?) {
        if(clickedView is Button) {
            var buttonNumber = 0
            when (clickedView.id) {
                R.id.square1 -> buttonNumber = 1
                R.id.square2 -> buttonNumber = 2
                R.id.square3 -> buttonNumber = 3
                R.id.square4 -> buttonNumber = 4
                R.id.square5 -> buttonNumber = 5
                R.id.square6 -> buttonNumber = 6
                R.id.square7 -> buttonNumber = 7
                R.id.square8 -> buttonNumber = 8
                R.id.square9 -> buttonNumber = 9
            }

            playGame(buttonNumber,clickedView)
        }
   }

    private fun playGame(buttonNumber: Int, clickedView: Button) {
        if(motamashe == 1){
            clickedView.text = "X"
            clickedView.setTextColor(Color.RED)
            motamashe = 2
            firstPlayer.add(buttonNumber)
            clickedView.setBackgroundColor(Color.BLACK)
        }else if(motamashe == 2){
            clickedView.text = "O"
            motamashe = 1
            secondPlayer.add(buttonNumber)
            clickedView.setTextColor(Color.WHITE)
            clickedView.setBackgroundColor(Color.BLUE)
        }
        clickedView.isEnabled = false
        check()
    }

    private fun check() {
        var winner = 0
        if(firstPlayer.contains(1)&&firstPlayer.contains(2)&&firstPlayer.contains(3)){
            winner = 1
        }
        if(firstPlayer.contains(4)&&firstPlayer.contains(5)&&firstPlayer.contains(6)){
            winner = 1
        }
        if(firstPlayer.contains(7)&&firstPlayer.contains(8)&&firstPlayer.contains(9)){
            winner = 1
        }
        if(firstPlayer.contains(1)&&firstPlayer.contains(4)&&firstPlayer.contains(7)){
            winner = 1
        }
        if(firstPlayer.contains(2)&&firstPlayer.contains(5)&&firstPlayer.contains(8)){
            winner = 1
        }
        if(firstPlayer.contains(3)&&firstPlayer.contains(6)&&firstPlayer.contains(9)){
            winner = 1
        }
        if(firstPlayer.contains(1)&&firstPlayer.contains(5)&&firstPlayer.contains(9)){
            winner = 1
        }
        if(firstPlayer.contains(3)&&firstPlayer.contains(5)&&firstPlayer.contains(7)){
            winner = 1
        }
        if(secondPlayer.contains(1)&&secondPlayer.contains(2)&&secondPlayer.contains(3)){
            winner = 2
        }
        if(secondPlayer.contains(4)&&secondPlayer.contains(5)&&secondPlayer.contains(6)){
            winner = 2
        }
        if(secondPlayer.contains(7)&&secondPlayer.contains(8)&&secondPlayer.contains(9)){
            winner = 2
        }
        if(secondPlayer.contains(1)&&secondPlayer.contains(4)&&secondPlayer.contains(7)){
            winner = 2
        }
        if(secondPlayer.contains(2)&&secondPlayer.contains(5)&&secondPlayer.contains(8)){
            winner = 2
        }
        if(secondPlayer.contains(3)&&secondPlayer.contains(6)&&secondPlayer.contains(9)){
            winner = 2
        }
        if(secondPlayer.contains(1)&&secondPlayer.contains(5)&&secondPlayer.contains(9)){
            winner = 2
        }
        if(secondPlayer.contains(3)&&secondPlayer.contains(5)&&secondPlayer.contains(7)){
            winner = 2
        }
        if (winner == 1){
            Toast.makeText(this, "Sagol $player1", Toast.LENGTH_SHORT).show()
            qula1 += 1
            motamashe = 1
        }else if(winner == 2){
            Toast.makeText(this, "Sagol $player2", Toast.LENGTH_SHORT).show()
            qula2 += 1
            motamashe = 2
        }else if(firstPlayer.size + secondPlayer.size == 9){
            Toast.makeText(this, "Frea", Toast.LENGTH_SHORT).show()
            restarti.isEnabled = true
            firstPlayer.clear()
            secondPlayer.clear()
        }
        if(winner > 0){
            pirveli.isEnabled = false
            meore.isEnabled = false
            mesame.isEnabled = false
            meotxe.isEnabled = false
            mexute.isEnabled = false
            meeqvse.isEnabled = false
            meshvide.isEnabled = false
            merve.isEnabled = false
            mecxre.isEnabled = false
            qulebi1.text = qula1.toString()
            qulebi2.text = qula2.toString()
            firstPlayer.clear()
            secondPlayer.clear()
            restarti.isEnabled = true
        }

    }

}

