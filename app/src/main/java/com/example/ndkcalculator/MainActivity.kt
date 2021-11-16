package com.example.ndkcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.firstlibrary.Toaster
import com.example.ndkcalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.hisobla.setOnClickListener {
            val number1 = binding.number1.text.toString().toInt()
            val number2 = binding.number2.text.toString().toInt()
            val plusNumbrs = plusNumbrs(number1, number2)
            val minusNumbrs = minusNumbrs(number1, number2)
            binding.natija.text = plusNumbrs.toString() + "\n" + minusNumbrs.toString()
        }
    }

    external fun plusNumbrs(x: Int, y: Int): Int
    external fun minusNumbrs(x: Int, y: Int): Int

    companion object {
        init {
            System.loadLibrary("ndkcalculator")
        }
    }
}