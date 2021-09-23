package com.example.getpost_retrofit_pr.repository

import com.example.getpost_retrofit_pr.api.RetrofitInstance
import com.example.getpost_retrofit_pr.model.Post
import retrofit2.Response


//TODO( File REPOSITORY return class which will represent our repository )


/** * File REPOSITORY return class which will represent our repository
 * */
class Repository {
    //to stop existing from app when connection is unsuccessful whe have to change return type getPost()
    // from Post -> Response<Post>
    suspend fun getPost(): Response<Post> {
        return RetrofitInstance.api.getPost()
    }

    suspend fun getPost2(number: Int): Response<Post> {
        return RetrofitInstance.api.getPost2(number)

    }

    suspend fun getCustomPosts(userId: Int, sort: String, order: String): Response<List<Post>> {
        return RetrofitInstance.api.getCustomPost(userId, sort, order)
    }



/** * getCustomPosts2(userId: Int, options: Map<String, String>)
 *
 * */
    suspend fun getCustomPosts2(userId: Int, options: Map<String, String>): Response<List<Post>>{
        return RetrofitInstance.api.getCustomPosts2(userId, options)
    }

    suspend fun pushPost(post: Post): Response<Post> {
        return RetrofitInstance.api.pushPost(post)
    }

    suspend fun pushPost2(userId: Int, id: Int, title: String, body: String): Response<Post> {
        return RetrofitInstance.api.pushPost2(userId, id, title, body)
    }


}