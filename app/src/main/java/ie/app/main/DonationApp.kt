package ie.app.main

import android.app.Application
import android.util.Log
import android.widget.Toast
import ie.app.database.DBManager
import ie.app.models.Donation

class DonationApp : Application() {
    val target = 10000
    var totalDonated = 0

    //var dbManager: DBManager? = null
    var donations: MutableList<Donation> = ArrayList()
    fun newDonation(donation: Donation): Boolean {
        val targetAchieved = totalDonated > target
        if (!targetAchieved) {
            //dbManager!!.add(donation)
            donations.add(donation)
            totalDonated += donation.amount
        } else {
            Toast.makeText(this, "Target Exceeded!", Toast.LENGTH_SHORT).show()
        }
        return targetAchieved
    }

    override fun onCreate() {
        super.onCreate()
        Log.v("Donate", "Donation App Started")
        //dbManager = new DBManager(this);
        //Log.v("Donate", "Database Created");
    }
}