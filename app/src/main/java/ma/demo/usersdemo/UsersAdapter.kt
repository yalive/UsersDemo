package ma.demo.usersdemo

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


val TAG = "LOG_UsersAdapter"

class UsersAdapter(val users: List<User>) : RecyclerView.Adapter<UsersAdapter.UsersViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        Log.d(TAG, "onCreateViewHolder")
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_user, parent, false)
        return UsersViewHolder(view)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder for position: $position")
        val user = users[position]
        holder.bind(user)
    }


    inner class UsersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val txtFullName = itemView.findViewById<TextView>(R.id.txtFullName)
        private val txtEmail = itemView.findViewById<TextView>(R.id.txtEmail)
        private val imgUser = itemView.findViewById<ImageView>(R.id.imgUser)

        @SuppressLint("SetTextI18n")
        fun bind(user: User) {
            txtFullName.text = "${user.firstName} ${user.lastName}"
            txtEmail.text = user.email
            Picasso.get().load(user.imageUrl).into(imgUser)
        }
    }

}