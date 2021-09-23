package com.example.getpost_retrofit_pr.model


/** DataClass Post have special items to use like:
 * *  val userId: Int,
 * *  val id: Int,
 * *  val title: String,
 * *  val body: String
 * */
data class Post(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)
