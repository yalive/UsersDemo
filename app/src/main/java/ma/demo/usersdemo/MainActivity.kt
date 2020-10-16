package ma.demo.usersdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadUsers()
    }

    private fun loadUsers() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://reqres.in/api/")
            .addConverterFactory(GsonConverterFactory.create()) // Convert json to kotlin object
            .build()
        val api = retrofit.create(UsersApi::class.java)

        // Afficher loading

        val call = api.getUsers()
        call.enqueue(object : Callback<UsersResponse?> {
            override fun onFailure(call: Call<UsersResponse?>, t: Throwable) {
                // Show error message
                // hide loading
            }

            override fun onResponse(
                call: Call<UsersResponse?>,
                response: Response<UsersResponse?>
            ) {
                // hide loading
                if (response.isSuccessful) {
                    val users = response.body()?.users
                    if (users != null) {
                        val adapter = UsersAdapter(users)
                        recyclerView.adapter = adapter
                    }
                }
            }
        })
    }
}