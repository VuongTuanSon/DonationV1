package ie.app.activities

import android.os.Bundle
import android.view.*
import android.widget.*
import android.widget.AdapterView.OnItemClickListener
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
import ie.app.R


class Report : Base(), OnItemClickListener {
    var mSwipeRefreshLayout: SwipeRefreshLayout? = null
    var listView: ListView? = null
    var adapter: DonationAdapter? = null
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report)
        listView = findViewById<View>(R.id.reportList) as ListView
        mSwipeRefreshLayout = findViewById<View>(R.id.report_swipe_refresh_layout) as SwipeRefreshLayout
        GetAllTask(this).execute("/donations")
        mSwipeRefreshLayout!!.setOnRefreshListener(OnRefreshListener { GetAllTask(this@Report).execute("/donations") })

    }

    override fun onItemClick(arg0: AdapterView<*>?, arg1: View, pos: Int, id: Long) {
        Toast.makeText(this, """You Selected Row [ $pos]
For Donation Data [ ${adapter!!.donations[pos]}]
 With ID of [$id]""", Toast.LENGTH_LONG).show()
    }
}

