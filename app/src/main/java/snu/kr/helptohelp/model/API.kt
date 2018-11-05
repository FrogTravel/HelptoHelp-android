package snu.kr.helptohelp.model

class API{
    companion object {
        fun getUserProfileData(searchQuery: SearchQuery) : List<UserProfileData> =  listOf(UserProfileData(User(0,"Name1"),
                reviews = listOf(Review("bla bla1", User(0, "user0"), 5)),
                history = listOf(History("his 1", 2), History("his 2", 5))),
                UserProfileData(User(1, "Name2"),
                        reviews = listOf(Review("bla bla1", User(0, "user0"), 5), Review("bla bla 2", User(0, "user0"), 5)),
                        history = listOf(History("his 1", 2), History("his 2", 5))))


        fun getUsers(searchQuery: SearchQuery) : List<User> = listOf(User(0,"Name1"),
                User(1, "Name2"))

        fun getUser(id: Int) = User(id, "SOME_NAME_FOR_THAT_USER")

        fun getUserProfileData(id: Int) = UserProfileData(User(id, "SOME_NAME_FOR_THAT_USER"),
                reviews = listOf(Review("bla bla1", User(0, "user0"), 5), Review("bla bla2", User(0, "user0"), 5)),
                history = listOf(History("his 1", 2), History("his 2", 5)))
    }
}