package snu.kr.helptohelp.model

import java.io.Serializable

data class SearchQuery(val language: String,
                       val address: String,
                       val name: String) : Serializable{
    fun getMap() = mapOf(Pair("language", language),
            Pair("address", address),
            Pair("name", name))
}