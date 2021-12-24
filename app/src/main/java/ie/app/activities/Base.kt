package ie.app.activities

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ie.app.R
import ie.app.api.DonationApi
import ie.app.models.Donation


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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_donate, menu)
        return true
    }

    override fun onPrepareOptionsMenu(menu: Menu): Boolean {
        super.onPrepareOptionsMenu(menu)
        val report: MenuItem = menu.findItem(R.id.menuReport)
        val donate: MenuItem = menu.findItem(R.id.menuDonate)
        if (donations.isEmpty()) report.setEnabled(false) else report.setEnabled(true)
        if (this is Donate) {
            donate.isVisible = false
            if (!donations.isEmpty()) report.setVisible(true)
        } else {
            report.isVisible = false
            donate.isVisible = true
        }
        return true
    }

    fun report(item: MenuItem?) {
        startActivity(Intent(this, Report::class.java))
    }

    fun donate(item: MenuItem?) {
        startActivity(Intent(this, Donate::class.java))
    }

    open fun reset(item: MenuItem?) {}
    companion object {
        var donations: MutableList<Donation> = ArrayList()
    }
}
