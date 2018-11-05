package snu.kr.helptohelp.model

data class UserProfileData(val user: User, val reviews: List<Review>, val history : List<Event>)