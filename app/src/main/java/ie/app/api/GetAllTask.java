package ie.app.api;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.util.List;

import ie.app.models.Donation;

class GetAllTask extends AsyncTask<String, Void, List<Donation>> {
    protected ProgressDialog dialog;
    protected Context context;
    public GetAllTask(Context context)
    {
        this.context = context;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        this.dialog = new ProgressDialog(context, 1);
        this.dialog.setMessage("Retrieving Donations List");
        this.dialog.show();
    }
    @Override
    protected List<Donation> doInBackground(String... params) {
        try {
            Log.v("donate", "Donation App Getting All Donations");
            return (List<Donation>) DonationApi.getAll((String) params[0]);
        }
        catch (Exception e) {
            Log.v("donate", "ERROR : " + e);
            e.printStackTrace();
        }
        return null;
    }
    @Override
    protected void onPostExecute(List<Donation> result) {
        super.onPostExecute(result);
        //use result to calculate the totalDonated amount here
        progressBar.setProgress(app.totalDonated);
        amountTotal.setText("$" + app.totalDonated);
        if (dialog.isShowing())
            dialog.dismiss();
    }
}