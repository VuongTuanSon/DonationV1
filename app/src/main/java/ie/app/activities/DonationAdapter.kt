package ie.app.activities

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import ie.app.R
import ie.app.models.Donation


class DonationAdapter(context: Context, var donations: List<Donation>) : ArrayAdapter<Donation?>(context, R.layout.row_donate, donations) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view: View = inflater.inflate(R.layout.row_donate, parent, false)
        val donation = donations[position]
        val amountView = view.findViewById<View>(R.id.row_amount) as TextView
        val methodView = view.findViewById<View>(R.id.row_method) as TextView
        val upvotesView = view.findViewById<View>(R.id.row_upvotes) as TextView
        amountView.text = "" + donation.amount
        methodView.text = donation.paymenttype
        upvotesView.text = "" + donation.upvotes
        view.tag = donation._id // setting the 'row' id to the id of the donation
        return view
    }

    override fun getCount(): Int {
        return donations.size
    }
}
