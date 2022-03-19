package com.example.simpleins

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PostAdapter(val context: Context, val posts: ArrayList<Post>)
    : RecyclerView.Adapter<PostAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostAdapter.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_post,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostAdapter.ViewHolder, position: Int) {
        val post = posts.get(position)
        holder.bind(post)
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    fun clear() {
        posts.clear()
        notifyDataSetChanged()
    }

    // Add a list of items -- change to type used
    fun addAll(tweetList: List<Post>) {
        posts.addAll(tweetList)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val siUsername: TextView
        val ivImage: ImageView
        val siDescription: TextView

        init {
            siUsername = itemView.findViewById(R.id.siUserName)
            ivImage = itemView.findViewById(R.id.ivImage)
            siDescription = itemView.findViewById(R.id.siDescription)
        }

     fun bind(post: Post){
         siDescription.text = post.getDescrption()
         siUsername.text = post.getUser()?.username

         Glide.with(itemView.context).load(post.getImage()?.url).into(ivImage)
     }

    }
}