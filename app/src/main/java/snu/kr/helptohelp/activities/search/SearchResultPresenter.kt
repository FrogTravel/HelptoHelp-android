package snu.kr.helptohelp.activities.search

import snu.kr.helptohelp.model.API
import snu.kr.helptohelp.model.SearchQuery
import snu.kr.helptohelp.model.User

class SearchResultPresenter(val view: SearchResult.View) : SearchResult.Presenter{
    private var users : List<User> = listOf()

    override fun setSearchQuery(searchQuery: SearchQuery) {
        requestUsers(searchQuery)

    }

    override fun onSearchButton() {
        view.searchForPeople()
    }

    fun requestUsers(searchQuery: SearchQuery){
        users = API.getUsers(searchQuery)
        view.showUsers(users)
    }
}