package snu.kr.helptohelp.activities.searchResult

import snu.kr.helptohelp.model.event.Event
import snu.kr.helptohelp.model.SearchQuery

interface SearchResult {
    interface View {
        fun searchForPeople()
        fun showResults(events: List<Event>)
        fun showError()
    }

    interface Presenter {
        fun setSearchQuery(searchQuery: SearchQuery)
        fun onSearchButton()
    }
}