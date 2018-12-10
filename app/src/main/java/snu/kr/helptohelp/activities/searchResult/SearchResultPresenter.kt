package snu.kr.helptohelp.activities.searchResult

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import snu.kr.helptohelp.model.*

class SearchResultPresenter(val view: SearchResult.View) : SearchResult.Presenter {

    override fun setSearchQuery(searchQuery: SearchQuery) {
        request(searchQuery)
    }

    override fun onSearchButton() {
        view.searchForPeople()
    }

    private fun request(searchQuery: SearchQuery) {
//        val events = APIPseudo.searchEvent(searchQuery)

        val api = API.create()
        api.findMatch(LocalUser.user.id, searchQuery.getMap()).enqueue(object : Callback<PostAnswerMatchUser> {
            override fun onFailure(call: Call<PostAnswerMatchUser>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<PostAnswerMatchUser>, response: Response<PostAnswerMatchUser>) {
                if (response.isSuccessful) {
                    val users = response.body()
                    if (users != null) {
                        view.showResults(users.dataArrayList)

                    }
                }
            }

        })


    }
}