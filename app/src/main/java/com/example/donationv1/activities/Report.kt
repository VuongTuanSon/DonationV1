package com.example.donationv1.activities

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.donationv1.R


class Report : AppCompatActivity() {
    var listView: ListView? = null
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report)
        listView = findViewById<View>(R.id.reportList) as ListView
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1, numbers
        )
        listView!!.setAdapter(adapter)
    }

    companion object {
        val numbers = arrayOf(
            "Amount, Pay method",
            "10, Direct",
            "100, PayPal",
            "1000, Direct",
            "10, PayPal",
            "5000, PayPal"
        )
    }
}
