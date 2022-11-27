package com.partitionsoft.dicerollerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
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
        val dice = Dice(6, 6)
        val diceRoll = dice.roll()
        val diceSecondRoll = dice.rollDice()
        val luckyNumber = 4
        println("Your ${dice.numSide} sided dice first rolled ${diceRoll} and second ${diceSecondRoll}!")


        when (diceRoll) {
            luckyNumber -> println("Congratulations! You won")
            1 -> println("So sorry! You rolled a 1. Try again!")
            2 -> println("Sadly, you rolled a 2. Try again!")
            3 -> println("Unfortunately, you rolled a 3. Try again!")
            5 -> println("Don't cry! You rolled a 5. Try again!")
            6 -> println("Apologies! You rolled a 6. Try again!")
        }

        when(diceSecondRoll) {
            luckyNumber -> println("Lucky number! You are the best")
            1 -> println("So sorry! You rolled a 1. Try again!")
            2 -> println("Sadly, you rolled a 2. Try again!")
            3 -> println("Unfortunately, you rolled a 3. Try again!")
            5 -> println("Don't cry! You rolled a 5. Try again!")
            6 -> println("Apologies! You rolled a 6. Try again!")
        }

        // Determine which drawable resource ID to use based on the dice roll
        val diceImage: ImageView = findViewById(R.id.dice_img)
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> {R.drawable.dice_6}
        }

        // Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResource)


        val diceSecondImage: ImageView = findViewById(R.id.dice_img_2)
        val drawableSecondResource = when (diceSecondRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> {R.drawable.dice_6}
        }

        // Update the content description
        diceSecondImage.setImageResource(drawableSecondResource)

        diceSecondImage.contentDescription = diceRoll.toString()
    }
}

class Dice(val numSide: Int, private val sideNum: Int) {

    fun roll(): Int {
        return (1..numSide).random()
    }

    fun rollDice(): Int {
        return (0..sideNum).random()
    }
}