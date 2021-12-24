package ie.app.activities

import android.app.ProgressDialog
import android.content.Context
import android.os.AsyncTask
import android.util.Log
import ie.app.api.DonationApi
import ie.app.models.Donation


private abstract class GetAllTask(protected var context: Context) : AsyncTask<String?, Void?, List<Donation>?>() {
    protected var dialog: ProgressDialog? = null
    override fun onPreExecute() {
        super.onPreExecute()
        dialog = ProgressDialog(context, 1)
        dialog!!.setMessage("Retrieving Donations List")
        dialog!!.show()
    }

    protected override fun doInBackground(vararg params: String): List<Donation>? {
        try {
            Log.v("donate", "Donation App Getting All Donations")
            return DonationApi.getAll(params[0]) as List<Donation>
        } catch (e: Exception) {
            Log.v("donate", "ERROR : $e")
            e.printStackTrace()
        }
        return null
    }

    override fun onPostExecute(result: List<Donation>?) {
        super.onPostExecute(result)
        //use result to calculate the totalDonated amount here
        progressBar.setProgress(app.totalDonated)
        amountTotal.setText("$" + app.totalDonated)
        if (dialog!!.isShowing) dialog!!.dismiss()
    }
}
