package snu.kr.helptohelp.model

data class Review(val reviewText : String = "Nothing is here... Sorry",
                  val user: User, val userGrade: Int)