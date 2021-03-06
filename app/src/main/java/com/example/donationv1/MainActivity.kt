package com.example.donationv1

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class Donate : AppCompatActivity() {
    private var donateButton: Button? = null
    private var paymentMethod: RadioGroup? = null
    private var progressBar: ProgressBar? = null
    private var amountPicker: NumberPicker? = null
    private var totalDonated = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_donate)
//        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
//        setSupportActionBar(toolbar)
        donateButton = findViewById<View>(R.id.donateButton) as Button
        if (donateButton != null) {
            Log.v("Donate", "Really got the donate button")
        }
        paymentMethod = findViewById<View>(R.id.paymentMethod) as RadioGroup
        progressBar = findViewById<View>(R.id.progressBar) as ProgressBar
        amountPicker = findViewById<View>(R.id.amountPicker) as NumberPicker
        amountPicker!!.minValue = 0
        amountPicker!!.maxValue = 1000
        progressBar!!.max = 10000
    }
//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        menuInflater.inflate(R.menu.menu_donate, menu)
//        return true
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        val id = item.itemId
//        return if (id == R.id.action_settings) {
//            true
//        } else super.onOptionsItemSelected(item)
//    }

    fun donateButtonPressed(view: View?) {
        val amount = amountPicker!!.value
        val radioId = paymentMethod!!.checkedRadioButtonId
        val method = if (radioId == R.id.PayPal) "PayPal" else "Direct"
        totalDonated = totalDonated + amount
        progressBar!!.progress = totalDonated
        Log.v(
                "Donate", "Donate Pressed! with amount " + amount + ", method: " +
                method
        )
        Log.v("Donate", "Current total $totalDonated")
    }


}