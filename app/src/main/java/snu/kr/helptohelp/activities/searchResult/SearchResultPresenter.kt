package snu.kr.helptohelp.activities.searchResult

import snu.kr.helptohelp.model.APIPseudo
import snu.kr.helptohelp.model.SearchQuery

class SearchResultPresenter(val view: SearchResult.View) : SearchResult.Presenter {

    override fun setSearchQuery(searchQuery: SearchQuery) {
        request(searchQuery)
    }

    override fun onSearchButton() {
        view.searchForPeople()
    }

    private fun request(searchQuery: SearchQuery) {
        val events = APIPseudo.searchEvent(searchQuery)

        if (events.isNotEmpty()) {
            view.showResults(events)
        }else{
            view.showError()
        }
    }
}