package edu.temple.inclassuiacvitivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val displayTextView = findViewById<TextView>(R.id.textDisplay)

        /* Step 1: Populate this array */
        val numberArray = arrayOfNulls<Number>(11)

        for (i in numberArray.indices) {
            numberArray[i] = i * i
        }

        /* Step 2: Create adapter to display items from array in Spinner */
        spinner.adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, numberArray)


        // Step 3: Change TextView's text size to the number selected in the Spinner */
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>, p1: View, p2: Int, id: Long) {
                p0?.run {
                    val selectedSize = numberArray[p2]?.toFloat()

                    if (selectedSize != null) {
                        displayTextView.textSize = selectedSize
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Do nothing here
                // auto generated
            }
        }

    }
}