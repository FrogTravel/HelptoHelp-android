package snu.kr.helptohelp.model

data class Event(val hostUser: User, val title: String, val description: String,
                 val location: String)