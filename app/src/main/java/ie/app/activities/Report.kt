package com.example.donationv1.activities

import android.os.Bundle
import android.view.View
import android.widget.ListView
import com.example.donationv1.R
import ie.app.activities.DonationAdapter


class Report : Base() {
    var listView: ListView? = null
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report)
        listView = findViewById<View>(R.id.reportList) as ListView
        val adapter = DonationAdapter(this, donations)
        listView!!.adapter = adapter
    }
}
