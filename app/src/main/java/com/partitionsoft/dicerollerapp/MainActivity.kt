package com.partitionsoft.dicerollerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

/**
 * This activity allows user to roll a dice and view the results on the screen
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollerButton: Button = findViewById(R.id.btn_dice)
        rollerButton.setOnClickListener { rollDice() }
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(100, 200)
        val diceRoll = dice.roll()
        val diceSecondRoll = dice.rollDice()

        //Update the screen after dice roll
        val resultTextView: TextView = findViewById(R.id.first_word_tv)
        resultTextView.text = diceRoll.toString()

        //Update the second screen after dice roll
        val resultSecondTextView: TextView = findViewById(R.id.second_word_tv)
        resultSecondTextView.text = diceSecondRoll.toString()
    }
}

class Dice(private val numSide: Int, private val sideNum:Int) {

    fun roll(): Int {
        return (1..numSide).random()
    }

    fun rollDice():Int {
        return (0..sideNum).random()
    }
}