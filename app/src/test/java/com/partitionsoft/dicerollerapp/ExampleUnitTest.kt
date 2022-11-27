package com.partitionsoft.dicerollerapp

import org.junit.Assert.assertTrue
import org.junit.Test


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun generates_number() {
        val dice = Dice(6, 6)
        val rollFirstResult = dice.roll()
        val rollSecondResult = dice.rollDice()
        assertTrue("The value of rollFirstResult was not between 1 and 6", rollFirstResult in 1..6)
        assertTrue("The value of rollSecondResult was not between 1 and 6", rollSecondResult in 1..6)
    }

}