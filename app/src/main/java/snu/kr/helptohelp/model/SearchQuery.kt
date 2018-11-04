package snu.kr.helptohelp.model

import java.io.Serializable

data class SearchQuery(val typeOfFood: Int, val city: String) : Serializable