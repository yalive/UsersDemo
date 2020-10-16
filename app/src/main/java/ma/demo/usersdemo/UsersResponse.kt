package ma.demo.usersdemo

import com.google.gson.annotations.SerializedName


class UsersResponse(
    val page: Int,
    @SerializedName("data")
    val users: List<User>
)

