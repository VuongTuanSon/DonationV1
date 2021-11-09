package com.example.donationv1.activities

import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.donationv1.Donate
import com.example.donationv1.R
import com.example.donationv1.models.Donation


open class Base : AppCompatActivity() {
    val target = 10000
    var totalDonated = 0
    fun newDonation(donation: Donation): Boolean {
        val targetAchieved = totalDonated > target
        if (!targetAchieved) {
            donations.add(donation)
            totalDonated += donation.amount
        } else {
            val toast = Toast.makeText(this, "Target Exceeded!", Toast.LENGTH_SHORT)
            toast.show()
        }
        return targetAchieved
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_donate, menu)
        return true
    }

    override fun onPrepareOptionsMenu(menu: Menu): Boolean {
        super.onPrepareOptionsMenu(menu)
        val report: MenuItem = menu.findItem(R.id.menuReport)
        val donate: MenuItem = menu.findItem(R.id.menuDonate)
        if (donations.isEmpty()) report.setEnabled(false) else report.setEnabled(true)
        if (this is Donate) {
            donate.setVisible(false)
            if (!donations.isEmpty()) report.setVisible(true)
        } else {
            report.setVisible(false)
            donate.setVisible(true)
        }
        return true
    }

    fun settings(item: MenuItem?) {
        Toast.makeText(this, "Settings Selected", Toast.LENGTH_SHORT).show()
    }

    fun report(item: MenuItem?) {
        startActivity(Intent(this, Report::class.java))
    }

    fun donate(item: MenuItem?) {
        startActivity(Intent(this, Donate::class.java))
    }

    companion object {
        var donations: MutableList<Donation> = ArrayList()
    }
}