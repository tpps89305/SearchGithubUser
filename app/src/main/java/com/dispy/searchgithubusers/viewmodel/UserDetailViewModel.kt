package com.dispy.searchgithubusers.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dispy.searchgithubusers.bean.User
import com.dispy.searchgithubusers.function.GithubCommand
import com.dispy.searchgithubusers.function.OnGithubUserDetailListener

class UserDetailViewModel {

    private val user: MutableLiveData<User> = MutableLiveData()

    fun getUser(): LiveData<User> {
        return user
    }

    fun getData(login: String) {
        GithubCommand().getUserDetail(login, object : OnGithubUserDetailListener {
            override fun onSuccess(result: User) {
                this@UserDetailViewModel.user.value = result
            }

            override fun onFailure(message: String) {

            }

        })
    }

}