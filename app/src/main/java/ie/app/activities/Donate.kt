package ie.app.activities

import android.app.ProgressDialog
import android.content.Context
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import ie.app.R
import ie.app.api.DonationApi
import ie.app.models.Donation


//class Donate : Base() {
//    private var donateButton: Button? = null
//    private var paymentMethod: RadioGroup? = null
//    private var progressBar: ProgressBar? = null
//    private var amountPicker: NumberPicker? = null
//    private var amountText: EditText? = null
//    private var amountTotal: TextView? = null
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_donate)
//        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
//        setSupportActionBar(toolbar)
//        donateButton = findViewById<View>(R.id.donateButton) as Button
//        paymentMethod = findViewById<View>(R.id.paymentMethod) as RadioGroup
//        progressBar = findViewById<View>(R.id.progressBar) as ProgressBar
//        amountPicker = findViewById<View>(R.id.amountPicker) as NumberPicker
//        amountText = findViewById<View>(R.id.paymentAmount) as EditText
//        amountTotal = findViewById<View>(R.id.totalSoFar) as TextView
//        amountPicker!!.minValue = 0
//        amountPicker!!.maxValue = 1000
//        progressBar!!.max = 10000
//        amountTotal!!.text = "$" + app!!.totalDonated
//    }
//
//    fun donateButtonPressed(view: View?) {
//        val method = if (paymentMethod!!.checkedRadioButtonId == R.id.PayPal) "PayPal" else "Direct"
//        var donatedAmount = amountPicker!!.value
//        if (donatedAmount == 0) {
//            val text = amountText!!.text.toString()
//            if (text != "") donatedAmount = text.toInt()
//        }
//        if (donatedAmount > 0) {
//            app!!.newDonation(Donation(donatedAmount, method))
//            progressBar!!.progress = app!!.totalDonated
//            val totalDonatedStr = "$" + app!!.totalDonated
//            amountTotal!!.text = totalDonatedStr
//        }
//    }
//
//    override fun reset(item: MenuItem?) {
//        app.donations.clear()
//        app.totalDonated = 0
//        amountTotal!!.text = "$" + app.totalDonated
//        progressBar!!.progress = app.totalDonated
//    }
//}

class Donate : Base() {
    var mSwipeRefreshLayout: SwipeRefreshLayout? = null
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
            newDonation(Donation(donatedAmount, method, 0))
            progressBar!!.progress = totalDonated
            val totalDonatedStr = "$$totalDonated"
            amountTotal!!.text = totalDonatedStr
        }
    }
}

