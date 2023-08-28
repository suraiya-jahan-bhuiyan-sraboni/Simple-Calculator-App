package com.example.simplecalculator

import android.os.Bundle
import android.text.TextUtils
import android.text.method.ScrollingMovementMethod
import androidx.appcompat.app.AppCompatActivity
import com.example.simplecalculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

//private lateinit var binding:ActivityMainBinding
private  var input: String=""

private var bracketsCount = 0
class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        input= binding.inputexpression.text.toString()
        binding.inputexpression.ellipsize=TextUtils.TruncateAt.MARQUEE
        binding.inputexpression.isSingleLine=true
        binding.inputexpression.isSelected=true
        binding.answerView.movementMethod= ScrollingMovementMethod()

        binding.zero.setOnClickListener {

            input += "0"
            binding.inputexpression.text = input

        }
        binding.one.setOnClickListener {

            input += "1"
            binding.inputexpression.text = input
        }
        binding.two.setOnClickListener {

            input += "2"
            binding.inputexpression.text = input

        }
        binding.three.setOnClickListener {

            input += "3"
            binding.inputexpression.text = input
        }
        binding.four.setOnClickListener {

            input += "4"
            binding.inputexpression.text = input
        }
        binding.five.setOnClickListener {

            input += "5"
            binding.inputexpression.text = input
        }
        binding.six.setOnClickListener {

            input += "6"
            binding.inputexpression.text = input
        }
        binding.seven.setOnClickListener {

            input += "7"
            binding.inputexpression.text = input
        }
        binding.eight.setOnClickListener {

            input += "8"
            binding.inputexpression.text = input
        }
        binding.nine.setOnClickListener {

            input += "9"
            binding.inputexpression.text = input
        }
        binding.dot.setOnClickListener {
            input += "."
            binding.inputexpression.text = input
        }
        binding.allclear.setOnClickListener {
            input = ""
            binding.inputexpression.text = "0"
            binding.answerView.text = "="
        }
        binding.delete.setOnClickListener {
            if (input.isNotEmpty()) {
                input = input.substring(0, input.length - 1)
                binding.inputexpression.text = input
            }

        }
        binding.brakets.setOnClickListener {

            if (bracketsCount % 2 == 0) {
                input += "("
                bracketsCount++
            } else {
                input += ")"
                bracketsCount++
            }
            binding.inputexpression.text = input

        }
        binding.plus.setOnClickListener {
            input += "+"
            binding.inputexpression.text = input
        }
        binding.minus.setOnClickListener {
            input += "-"
            binding.inputexpression.text = input
        }
        binding.multiply.setOnClickListener {
            input += "*"
            binding.inputexpression.text = input
        }
        binding.division.setOnClickListener {
            input += "/"
            binding.inputexpression.text = input
        }
        binding.doublezero.setOnClickListener {
            input += "00"
            binding.inputexpression.text = input
        }
        binding.equal.setOnClickListener {
            // Handle the case where the expression is not empty
            if (input.isNotEmpty()) {
                try {
                    val result = evaluateExpression(input)
                    binding.answerView.text = "= $result"
                } catch (e: Exception) {
                    binding.answerView.text = "= Error"
                }
            }
        }
    }
    private fun evaluateExpression(expression: String): String {
        return try {
            val exp = ExpressionBuilder(expression).build()
            val result = exp.evaluate()
            result.toString()
        } catch (e: Exception) {
            throw e
        }
    }

}


