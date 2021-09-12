package com.example.counterlivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var instanceOfBooleanTextView : TextView
    private lateinit var instanceOfCounterTextView : TextView
    private lateinit var instanceOfButton: Button
    private lateinit var instanceOfViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        instanceOfBooleanTextView = findViewById(R.id.booleanTextViewId)
        instanceOfCounterTextView = findViewById(R.id.counterTextViewId)
        instanceOfButton = findViewById(R.id.buttonId)

        /**
         * Get the view model we want to use in the main activity
         */
        instanceOfViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        /**
         * Persist data on configuration change
         */
        instanceOfCounterTextView.text = instanceOfViewModel.counter.toString()

        /**
         * Set condition to return what each text vews will display
         */
        if(instanceOfViewModel.counter == 0){
            instanceOfBooleanTextView.text = "..."
        }
        else if(instanceOfViewModel.counter % 2 == 0){
            instanceOfBooleanTextView.text = "Even"
        }
        else{
            instanceOfBooleanTextView.text = "Odd"
        }

        instanceOfButton.setOnClickListener { increaseCounterInMainActivity() }
    }

    private fun increaseCounterInMainActivity() {

        instanceOfViewModel.increaseCounterInMainViewModel()
        instanceOfCounterTextView.text = instanceOfViewModel.counter.toString()

        if(instanceOfViewModel.counter == 0){
            instanceOfBooleanTextView.text = "..."
        }
        else if(instanceOfViewModel.counter % 2 == 0){
            instanceOfBooleanTextView.text = "Even"
        }
        else{
            instanceOfBooleanTextView.text = "Odd"
        }

    }

}
