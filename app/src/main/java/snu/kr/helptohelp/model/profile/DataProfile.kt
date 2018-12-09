package snu.kr.helptohelp.model.profile

import snu.kr.helptohelp.model.Tag
import snu.kr.helptohelp.model.User

data class DataProfile(val profile: User, val tags : ArrayList<Tag>)