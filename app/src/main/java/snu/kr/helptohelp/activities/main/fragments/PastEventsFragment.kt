package snu.kr.helptohelp.activities.main.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_past_event.view.*
import snu.kr.helptohelp.R
import snu.kr.helptohelp.activities.main.util.EventsAdapter
import snu.kr.helptohelp.model.API

class PastEventsFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_past_event, container, false)
        view.recycler_view.adapter = EventsAdapter(API.getPastEventsForUsers(0))
        view.recycler_view.layoutManager = LinearLayoutManager(view.context)
        return view
    }
}

