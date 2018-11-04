package snu.kr.helptohelp.model

class API{
    companion object {
        fun getUsers(searchQuery: SearchQuery) : List<User> = listOf(User(0,"Name1",
                reviews = listOf(Review("bla bla1")),
                history = listOf(History("his 1", 2), History("his 2", 5))),
                User(1, "Name2",
                        reviews = listOf(Review("bla bla1"), Review("bla bla 2")),
                        history = listOf(History("his 1", 2), History("his 2", 5))))

        fun getUser(id: Int) = User(id, "SOME_NAME_FOR_THAT_USER",
                reviews = listOf(Review("bla bla1"), Review("bla bla 4")),
                history = listOf(History("his 1", 2), History("his 2", 5)))
    }
}