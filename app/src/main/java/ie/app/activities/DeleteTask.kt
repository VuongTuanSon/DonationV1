package ie.app.activities

private class DeleteTask extends AsyncTask<String, Void, String> {
    protected ProgressDialog dialog;
    protected Context context;
    public DeleteTask(Context context) {
        this.context = context;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        this.dialog = new ProgressDialog(context, 1);
        this.dialog.setMessage("Deleting Donation");
        this.dialog.show();
    }
    @Override
    protected String doInBackground(String... params) {
        try {
            return (String) DonationApi.delete((String) params[0], (String)
            params[1]);
        } catch (Exception e) {
            Log.v("donate", "ERROR : " + e);
            e.printStackTrace();
        }
        return null;
    }
    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        String s = result;
        Log.v("donate", "DELETE REQUEST : " + s);
        new GetAllTask(Report.this).execute("/donations");
        if (dialog.isShowing())
            dialog.dismiss();
    }
}
public void onDonationDelete(final Donation donation) {
    String stringId = donation._id;
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setTitle("Delete Donation?");
    builder.setIcon(android.R.drawable.ic_delete);
    builder.setMessage("Are you sure you want to Delete the \'Donation with ID
            \' \n [ "
    + stringId + " ] ?");
    builder.setCancelable(false);
    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int id) {
            new DeleteTask(Report.this).execute("/donations", donation._id);
        }
    }).setNegativeButton("No", new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int id) {
            dialog.cancel();
        }
    });
    AlertDialog alert = builder.create();
    alert.show();
}