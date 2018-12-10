package snu.kr.helptohelp.activities.searchResult

import snu.kr.helptohelp.model.event.Event
import snu.kr.helptohelp.model.SearchQuery
import snu.kr.helptohelp.model.UserMatch

interface SearchResult {
    interface View {
        fun searchForPeople()
        fun showResults(users: ArrayList<UserMatch>)
        fun showError()
    }

    interface Presenter {
        fun setSearchQuery(searchQuery: SearchQuery)
        fun onSearchButton()
    }
}