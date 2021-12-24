package ie.app.activities

import android.app.ProgressDialog
import android.content.Context
import android.os.AsyncTask
import android.util.Log
import android.widget.Toast
import ie.app.api.DonationApi
import ie.app.models.Donation


private class GetTask(context: Context) : AsyncTask<String?, Void?, Donation?>() {
    protected var dialog: ProgressDialog? = null
    protected var context: Context
    override fun onPreExecute() {
        super.onPreExecute()
        dialog = ProgressDialog(context, 1)
        dialog!!.setMessage("Retrieving Donation Details")
        dialog!!.show()
    }

    override fun doInBackground(vararg params: String?): Donation? {
        try {
            return DonationApi.get(params[0], params[1]) as Donation
        } catch (e: Exception) {
            Log.v("donate", "ERROR : $e")
            e.printStackTrace()
        }
        return null
    }

    override fun onPostExecute(result: Donation?) {
        super.onPostExecute(result)
        Toast.makeText(this@Report, """Donation Data [ ${result!!.upvotes}]
 With ID of [${result._id}]""", Toast.LENGTH_LONG).show()
        if (dialog!!.isShowing) dialog!!.dismiss()
    }

    init {
        this.context = context
    }
}
