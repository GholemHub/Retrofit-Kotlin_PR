package com.example.getpost_retrofit_pr.api

import com.example.getpost_retrofit_pr.model.Post
import retrofit2.Response
import retrofit2.http.*


interface SimpleApi {


    @GET("posts/1")
    /** * Function to senting a @GET request
     * *  @GET("posts/1")
     *
     */
    suspend fun getPost(): Response<Post>

    @GET("posts/{postNumber}")
    /** * Function to senting a @GET request
     * *  @GET("posts/{postNumber}")
     *
     */
    suspend fun getPost2(
        @Path("postNumber") number: Int
    ): Response<Post>

    @GET("posts")
    suspend fun getCustomPost(

        @Query("userId") userId: Int,
        @Query("_sort") sort: String,
        @Query("_order") order: String
    ): Response<List<Post>>

    @GET("posts")
    suspend fun getCustomPosts2(
        @Query("userId") userId: Int,
        @QueryMap options: Map<String, String>
    ): Response<List<Post>>

    @POST("posts")
    suspend fun pushPost(
        @Body post: Post
    ): Response<Post>

    @FormUrlEncoded
    @POST("posts")
    suspend fun pushPost2(
        @Field ("userId")userId: Int,
        @Field ("id")id: Int,
        @Field ("title")title: String,
        @Field ("body")body: String
    ): Response<Post>


}