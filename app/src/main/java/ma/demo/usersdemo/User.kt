package ma.demo.usersdemo

import com.google.gson.annotations.SerializedName


data class User(
    @SerializedName("first_name")
    val firstName: String,

    @SerializedName("last_name")
    val lastName: String,

    @SerializedName("email")
    val email: String,

    @SerializedName("avatar")
    val imageUrl: String
)