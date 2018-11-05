package snu.kr.helptohelp.model

data class Event(val id: Int = -1, val hostUser: User, val title: String, val description: String,
                 val location: String)