package snu.kr.helptohelp.activities.myEvents.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_future_events.view.*
import snu.kr.helptohelp.R
import snu.kr.helptohelp.activities.myEvents.util.EventsAdapter
import snu.kr.helptohelp.model.APIPseudo

class FutureEventsFragment : Fragment() {
    lateinit var adapter: EventsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_future_events, container, false)
        adapter = EventsAdapter(APIPseudo.getFutureEventsForUsers(0))
        view.recycler_view_future.adapter = adapter
        view.recycler_view_future.layoutManager = LinearLayoutManager(view.context)
        return view
    }

    override fun onResume() {
        super.onResume()
        Log.d("ADDDEB", "OnResume ${APIPseudo.getFutureEventsForUsers(0)}")
        adapter.notifyDataSetChanged()
    }
}

