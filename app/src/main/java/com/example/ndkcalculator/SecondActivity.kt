package com.example.ndkcalculator

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.ndkcalculator.databinding.ActivitySecondBinding
import com.github.angads25.toggle.interfaces.OnToggledListener
import com.github.angads25.toggle.model.ToggleableView
import com.github.angads25.toggle.widget.DayNightSwitch
import java.text.DecimalFormat
import java.text.ParseException


class SecondActivity : AppCompatActivity(), OnToggledListener {

    private lateinit var binding: ActivitySecondBinding
    private val decimalFormat = DecimalFormat("#.###")
    private var process = 0
    private var number1 = ""
    private var number2 = ""
    private var isHave = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            setTheme(R.style.ThemeOverlay_AppCompat_Dark)
        } else {
            setTheme(R.style.Theme_NdkCalculator)
        }

        binding.switch1.setOnToggledListener(this)
        binding.switch1.isOn = true

        binding.switch1.isOn =
            AppCompatDelegate.getDefaultNightMode() != AppCompatDelegate.MODE_NIGHT_YES


        binding.apply {
            plus.setOnClickListener {
                if (number1 != "") {
                    if (isHave && number2 != "") {
                        number1 = (number1.toDouble() + number2.toDouble()).toString()
                    }
                    calculate(number1, "", true)
                    process = 1
                }
            }
            minus.setOnClickListener {
                if (!isHave && number1 == "") {
                    calculate("-", number2, false)
                } else {
                    if (isHave && number2 != "") {
                        number1 = (number1.toDouble() - number2.toDouble()).toString()
                    }
                    calculate(number1, "", true)
                    process = 2
                }
            }
            mult.setOnClickListener {
                if (number1 != "") {
                    process = 3
                    if (isHave && number2 != "") {
                        number1 = (number1.toDouble() * number2.toDouble()).toString()
                    }
                    calculate(number1, "", true)
                }
            }
            div.setOnClickListener {
                if (number1 != "") {
                    process = 4
                    if (isHave && number2 != "") {
                        number1 = (number1.toDouble() / number2.toDouble()).toString()
                    }
                    calculate(number1, "", true)
                }
            }
            percent.setOnClickListener {
                if (number1 != "") {
                    process = 0
                    number1 = divadeNumbrs(number1.toDouble(), "100".toDouble()).toString()
                    calculate(number1, number2, false)
                }
            }
            plusMinus.setOnClickListener {
                if (number1 != "") {
                    process = 0
                    val index = number1.toDouble()
                    number1 = (-index).toString()
                    calculate(number1, number2, false)
                }
            }
            equal.setOnClickListener {
                if (number1 != "" && number2 != "" && process != 0) {
                    var result = ""
                    when (process) {
                        1 -> result = plusNumbrs(number1.toDouble(), number2.toDouble()).toString()
                        2 -> result = minusNumbrs(number1.toDouble(), number2.toDouble()).toString()
                        3 -> result =
                            multipNumbrs(number1.toDouble(), number2.toDouble()).toString()
                        4 -> result =
                            divadeNumbrs(number1.toDouble(), number2.toDouble()).toString()
                    }
                    calculate(result, number2, false)
                }
            }
            clear.setOnClickListener {
                calculate("", "", false)
                process = 0
            }
            delete.setOnClickListener {
                if (isHave) {
                    if (number2 != "") {
                        calculate(number1, number2.substring(0, n2.length() - 1), isHave)
                    } else {
                        calculate(number1, number2, false)
                    }
                } else {
                    if (number1 != "") {
                        calculate(number1.substring(0, n1.length() - 1), number2, isHave)
                    }
                }
            }

            dot.setOnClickListener {
                if (number1 != "") {
                    var b = true
                    if (isHave) {
                        var i = 0
                        while (i < number2.length) {
                            if (number2[i] == '.') {
                                b = false
                            }
                            i++
                        }
                        if (b) {
                            number2 += "."
                            edit.text = number2
                            isHave = true
                        }
                    } else {
                        var i = 0
                        while (i < number1.length) {
                            if (number1[i] == '.') {
                                b = false
                            }
                            i++
                        }
                        if (b) {
                            number1 += "."
                            edit.text = number1
                            isHave = false
                        }
                    }
                }
            }
            n0.setOnClickListener {
                if (isHave) {
                    calculate(number1, number2 + 0, true)
                } else {
                    calculate(number1 + 0, number2, false)
                }
            }
            n1.setOnClickListener {
                if (isHave) {
                    calculate(number1, number2 + 1, true)
                } else {
                    calculate(number1 + 1, number2, false)
                }
            }
            n2.setOnClickListener {
                if (isHave) {
                    calculate(number1, number2 + 2, true)
                } else {
                    calculate(number1 + 2, number2, false)
                }
            }
            n3.setOnClickListener {
                if (isHave) {
                    calculate(number1, number2 + 3, true)
                } else {
                    calculate(number1 + 3, number2, false)
                }
            }
            n4.setOnClickListener {
                if (isHave) {
                    calculate(number1, number2 + 4, true)
                } else {
                    calculate(number1 + 4, number2, false)
                }
            }
            n5.setOnClickListener {
                if (isHave) {
                    calculate(number1, number2 + 5, true)
                } else {
                    calculate(number1 + 5, number2, false)
                }
            }
            n6.setOnClickListener {
                if (isHave) {
                    calculate(number1, number2 + 6, true)
                } else {
                    calculate(number1 + 6, number2, false)
                }
            }
            n7.setOnClickListener {
                if (isHave) {
                    calculate(number1, number2 + 7, true)
                } else {
                    calculate(number1 + 7, number2, false)
                }
            }
            n8.setOnClickListener {
                if (isHave) {
                    calculate(number1, number2 + 8, true)
                } else {
                    calculate(number1 + 8, number2, false)
                }
            }
            n9.setOnClickListener {
                if (isHave) {
                    calculate(number1, number2 + 9, true)
                } else {
                    calculate(number1 + 9, number2, false)
                }
            }
        }

    }

    external fun plusNumbrs(a: Double, b: Double): Double
    external fun minusNumbrs(a: Double, b: Double): Double
    external fun divadeNumbrs(a: Double, b: Double): Double
    external fun multipNumbrs(a: Double, b: Double): Double

    companion object {
        init {
            System.loadLibrary("ndkcalculator")
        }
    }

    private fun calculate(number1: String, number2: String, isHave: Boolean) {
        val no1 = formatter(number1)
        val no2 = formatter(number2)
        this.number1 = no1
        this.number2 = no2
        this.isHave = isHave
        if (isHave) {
            binding.edit.text = no2
        } else {
            binding.edit.text = no1
        }
    }

    private fun formatter(parse: String): String {
        var str: String = parse
        try {
            str = decimalFormat.parse(parse).toString()
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return str
    }

    override fun onSwitched(toggleableView: ToggleableView?, isOn: Boolean) {
        if (isOn) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            binding.main.setBackgroundColor(Color.WHITE)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            binding.main.setBackgroundColor(Color.BLACK)
        }
    }
}