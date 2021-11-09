package com.example.donationv1

import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.donationv1.activities.Base
import com.example.donationv1.models.Donation
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar


class Donate : Base() {
    private var donateButton: Button? = null
    private var paymentMethod: RadioGroup? = null
    private var progressBar: ProgressBar? = null
    private var amountPicker: NumberPicker? = null
    private var amountText: EditText? = null
    private var amountTotal: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_donate)
//        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
//        setSupportActionBar(toolbar)
        donateButton = findViewById<View>(R.id.donateButton) as Button
        paymentMethod = findViewById<View>(R.id.paymentMethod) as RadioGroup
        progressBar = findViewById<View>(R.id.progressBar) as ProgressBar
        amountPicker = findViewById<View>(R.id.amountPicker) as NumberPicker
        amountText = findViewById<View>(R.id.paymentAmount) as EditText
        amountTotal = findViewById<View>(R.id.totalSoFar) as TextView
        amountPicker!!.minValue = 0
        amountPicker!!.maxValue = 1000
        progressBar!!.max = 10000
        amountTotal!!.text = "$0"
    }

    fun donateButtonPressed(view: View?) {
        val method = if (paymentMethod!!.checkedRadioButtonId == R.id.PayPal) "PayPal" else "Direct"
        var donatedAmount = amountPicker!!.value
        if (donatedAmount == 0) {
            val text = amountText!!.text.toString()
            if (text != "") donatedAmount = text.toInt()
        }
        if (donatedAmount > 0) {
            newDonation(Donation(donatedAmount, method))
            progressBar!!.progress = totalDonated
            val totalDonatedStr = "$$totalDonated"
            amountTotal!!.text = totalDonatedStr
        }
    }
}
