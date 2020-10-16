package ma.demo.usersdemo

import retrofit2.Call
import retrofit2.http.GET


interface UsersApi {
    @GET("https://reqres.in/api/users")
    fun getUsers(): Call<UsersResponse>
}