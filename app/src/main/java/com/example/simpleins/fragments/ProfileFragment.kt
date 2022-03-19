package com.example.simpleins.fragments

import android.util.Log
import com.example.simpleins.MainActivity
import com.example.simpleins.Post
import com.parse.FindCallback
import com.parse.ParseException
import com.parse.ParseQuery
import com.parse.ParseUser

class ProfileFragment : FeedFragment() {

    override fun queryPosts() {
        val query: ParseQuery<Post> = ParseQuery.getQuery(Post::class.java)
        query.include(Post.Key_User)
        query.whereEqualTo(Post.Key_User, ParseUser.getCurrentUser())
        query.addDescendingOrder("createdAt")
        query.findInBackground(object : FindCallback<Post> {
            override fun done(posts: MutableList<Post>?, e: ParseException?) {
                if(e != null){
                    Log.e(MainActivity.TAG, "Error")
                }else {
                    if(posts != null){
                        for (post in posts){
                            Log.i(TAG, "Post: " + post.getDescrption() + " , username:" +
                                    post.getUser()?.username)
                        }
                        allPosts.addAll(posts)
                        adapter.notifyDataSetChanged()
                    }
                }

            }

        })

    }
}