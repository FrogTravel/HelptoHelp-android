package snu.kr.helptohelp.activities.userPage.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_history.*
import snu.kr.helptohelp.R
import snu.kr.helptohelp.activities.userPage.util.UserHistoryAdapter
import snu.kr.helptohelp.model.event.Event
import java.io.Serializable

class FragmentHistory : Fragment() {
    companion object {
        val HISTORY_ARG = "history_args"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_history, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        history_recycler_view.adapter = UserHistoryAdapter((arguments?.getSerializable(HISTORY_ARG) as HistoryList).historyList)
        history_recycler_view.layoutManager = LinearLayoutManager(this.context)
    }

    data class HistoryList(val historyList: List<Event>) : Serializable

}


