package com.example.tictactoe




import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.collections.ArrayList
import kotlin.math.round


class MainActivity : AppCompatActivity(), View.OnClickListener {





    private var button1: Button? = null
    private var button2: Button? = null
    private var button3: Button? = null
    private var button4: Button? = null
    private var button5: Button? = null
    private var button6: Button? = null
    private var button7: Button? = null
    private var button8: Button? = null
    private var button9: Button? = null

    private var resetButton: Button? = null
    private var RoundButton = 0



    private var FirstPlayer = ArrayList<Int>()
    private var SecondPlayer = ArrayList<Int>()

    private var activePlayer = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }


    private fun init() {

        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)

        resetButton = findViewById(R.id.Restart)




        button1?.setOnClickListener(this)
        button2?.setOnClickListener(this)
        button3?.setOnClickListener(this)
        button4?.setOnClickListener(this)
        button5?.setOnClickListener(this)
        button6?.setOnClickListener(this)
        button7?.setOnClickListener(this)
        button8?.setOnClickListener(this)
        button9?.setOnClickListener(this)




        resetButton?.setOnClickListener {

            button1?.setBackgroundResource(android.R.drawable.btn_default)
            button2?.setBackgroundResource(android.R.drawable.btn_default)
            button3?.setBackgroundResource(android.R.drawable.btn_default)
            button4?.setBackgroundResource(android.R.drawable.btn_default)
            button5?.setBackgroundResource(android.R.drawable.btn_default)
            button6?.setBackgroundResource(android.R.drawable.btn_default)
            button7?.setBackgroundResource(android.R.drawable.btn_default)
            button8?.setBackgroundResource(android.R.drawable.btn_default)
            button9?.setBackgroundResource(android.R.drawable.btn_default)


            button1?.text = ""
            button2?.text = ""
            button3?.text = ""
            button4?.text = ""
            button5?.text = ""
            button6?.text = ""
            button7?.text = ""
            button8?.text = ""
            button9?.text = ""

            FirstPlayer.clear()
            SecondPlayer.clear()
            RoundButton.clear()

            activePlayer = 1


            setGameButtonsState(true)
        }
    }


    override fun onClick(clickedView: View?) {

        if (clickedView is Button?) {

            var buttonNumber = 0

            when (clickedView?.id) {

                R.id.button1 -> buttonNumber = 1
                R.id.button2 -> buttonNumber = 2
                R.id.button3 -> buttonNumber = 3
                R.id.button4 -> buttonNumber = 4
                R.id.button5 -> buttonNumber = 5
                R.id.button6 -> buttonNumber = 6
                R.id.button7 -> buttonNumber = 7
                R.id.button8 -> buttonNumber = 8
                R.id.button9 -> buttonNumber = 9
            }

            if (buttonNumber != 0) {
                playGame(buttonNumber, clickedView, RoundButton = 0)
            }
        }
    }


    private fun playGame(buttonNumber: Int, clickedButton: Button?, RoundButton: Int) {
        if (activePlayer == 1) {
            clickedButton?.text = "X"
            clickedButton?.setBackgroundColor(Color.RED)
            FirstPlayer.add(buttonNumber)
            activePlayer = 2


        } else {
            clickedButton?.text = "0"
            clickedButton?.setBackgroundColor(Color.GREEN)
            SecondPlayer.add(buttonNumber)
            activePlayer = 1
        }
        clickedButton?.isEnabled = false
        check()
    }

    private fun check() {
        var winnerPlayer = 0

        if (FirstPlayer.contains(1) && FirstPlayer.contains(2) && FirstPlayer.contains(3)) {
            winnerPlayer = 1
            RoundButton += 1
        }
        if (SecondPlayer.contains(1) && SecondPlayer.contains(2) && SecondPlayer.contains(3)) {
            winnerPlayer = 2
            RoundButton += 1
        }

        if (FirstPlayer.contains(4) && FirstPlayer.contains(5) && FirstPlayer.contains(6)) {
            winnerPlayer = 1
            RoundButton += 1
        }
        if (SecondPlayer.contains(4) && SecondPlayer.contains(5) && SecondPlayer.contains(6)) {
            winnerPlayer = 2
            RoundButton += 1
        }
        if (FirstPlayer.contains(7) && FirstPlayer.contains(8) && FirstPlayer.contains(9)) {
            winnerPlayer = 1
            RoundButton += 1
        }
        if (SecondPlayer.contains(7) && SecondPlayer.contains(8) && SecondPlayer.contains(9)) {
            winnerPlayer = 2
            RoundButton += 1
        }
        if (FirstPlayer.contains(1) && FirstPlayer.contains(4) && FirstPlayer.contains(7)) {
            winnerPlayer = 1
            RoundButton += 1
        }
        if (SecondPlayer.contains(1) && SecondPlayer.contains(4) && SecondPlayer.contains(7)) {
            winnerPlayer = 2
            RoundButton += 1
        }
        if (FirstPlayer.contains(2) && FirstPlayer.contains(5) && FirstPlayer.contains(8)) {
            winnerPlayer = 1
            RoundButton += 1
        }
        if (SecondPlayer.contains(2) && SecondPlayer.contains(5) && SecondPlayer.contains(8)) {
            winnerPlayer = 2
            RoundButton += 1
        }
        if (FirstPlayer.contains(3) && FirstPlayer.contains(6) && FirstPlayer.contains(9)) {
            winnerPlayer = 1
            RoundButton += 1
        }
        if (SecondPlayer.contains(3) && SecondPlayer.contains(6) && SecondPlayer.contains(9)) {
            winnerPlayer = 2
            RoundButton += 1
        }
        if (FirstPlayer.contains(1) && FirstPlayer.contains(5) && FirstPlayer.contains(9)) {
            winnerPlayer = 1
            RoundButton += 1
        }
        if (SecondPlayer.contains(1) && SecondPlayer.contains(5) && SecondPlayer.contains(9)) {
            winnerPlayer = 2
            RoundButton += 1
        }
        if (FirstPlayer.contains(3) && FirstPlayer.contains(5) && FirstPlayer.contains(7)) {
            winnerPlayer = 1
            RoundButton += 1
        }
        if (SecondPlayer.contains(3) && SecondPlayer.contains(5) && SecondPlayer.contains(7)) {
            winnerPlayer = 2
            RoundButton += 1
        }

        if (winnerPlayer != 0) {
            if (winnerPlayer == 1) {
                Toast.makeText(this, "X wins", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "O wins", Toast.LENGTH_SHORT).show()
            }
            setGameButtonsState(false)
        }
    }


    private fun setGameButtonsState(isEnabled: Boolean) {
        button1?.isEnabled = isEnabled
        button2?.isEnabled = isEnabled
        button3?.isEnabled = isEnabled
        button4?.isEnabled = isEnabled
        button5?.isEnabled = isEnabled
        button6?.isEnabled = isEnabled
        button7?.isEnabled = isEnabled
        button8?.isEnabled = isEnabled
        button9?.isEnabled = isEnabled

    }


}

private fun Int.clear() {

}