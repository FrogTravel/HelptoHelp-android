package snu.kr.helptohelp.model

import snu.kr.helptohelp.model.event.Event

data class UserProfileData(val user: User, val reviews: List<Review>, val history : List<Event>)