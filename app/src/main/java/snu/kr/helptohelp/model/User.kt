package snu.kr.helptohelp.model

data class User(val id: Int, var name : String, var username: String, var age: Int,
                var description : String,
                var imageURL : String = "https://www.w3schools.com/howto/img_avatar2.png",
                var isVerified : Boolean)