package snu.kr.helptohelp.model

data class UserMatchPost(var language: String,
                         var address: String,
                         var name: String){
    fun getMap() = mapOf(Pair("language", language),
            Pair("address", address),
            Pair("name", name))
}