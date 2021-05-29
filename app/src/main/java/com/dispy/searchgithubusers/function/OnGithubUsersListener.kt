package com.dispy.searchgithubusers.function

import com.dispy.searchgithubusers.bean.User

interface OnGithubUsersListener {
    fun onSuccess(result: List<User>)
    fun onFailure(message: String)
}