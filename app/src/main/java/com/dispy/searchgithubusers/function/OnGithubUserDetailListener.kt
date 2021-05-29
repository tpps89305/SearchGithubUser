package com.dispy.searchgithubusers.function

import com.dispy.searchgithubusers.bean.User

interface OnGithubUserDetailListener {
    fun onSuccess(result: User)
    fun onFailure(message: String)
}