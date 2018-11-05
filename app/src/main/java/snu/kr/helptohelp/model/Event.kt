package snu.kr.helptohelp.model

data class Event(val id: Int, val hostUser: User, val title: String, val description: String,
                 val location: String)