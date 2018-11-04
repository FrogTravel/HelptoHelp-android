package snu.kr.helptohelp.activities.search

import snu.kr.helptohelp.model.SearchQuery
import snu.kr.helptohelp.model.User

interface SearchResult {
    interface View {
        fun searchForPeople()
        fun showUsers(users: List<User>)
    }

    interface Presenter {
        fun setSearchQuery(searchQuery: SearchQuery)
        fun onSearchButton()
    }
}