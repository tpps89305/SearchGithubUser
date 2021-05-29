package com.dispy.searchgithubusers.function

import com.dispy.searchgithubusers.bean.User
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubService {

    @GET("/search/users")
    fun searchUsers(@Query("q") query: String): Call<ResponseBody>

    @GET("users/{login}")
    fun getUserDetail(@Path("login") login: String): Call<User>
}