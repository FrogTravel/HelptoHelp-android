package snu.kr.helptohelp.model

data class User(val id: Int, var name : String, var username: String, var age: Int,
                var description : String,
                var profile_pic_url : String = "https://reviews.financesonline.com/media/themes/apps/images/img_placeholder_avatar.jpg",
                var isVerified : Boolean)