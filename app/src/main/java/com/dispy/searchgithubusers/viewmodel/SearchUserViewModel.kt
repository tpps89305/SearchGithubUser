package com.dispy.searchgithubusers.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dispy.searchgithubusers.bean.User
import com.dispy.searchgithubusers.function.GithubCommand
import com.dispy.searchgithubusers.function.OnGithubUsersListener

class SearchUserViewModel {

    private val users: MutableLiveData<List<User>> = MutableLiveData()

    fun getUsers(): LiveData<List<User>> {
        return users
    }

    fun searchUsers(query: String) {
        GithubCommand().searchUsers(query = query, object : OnGithubUsersListener {
            override fun onSuccess(result: List<User>) {
                this@SearchUserViewModel.users.value = result
            }

            override fun onFailure(message: String) {

            }

        })
    }

}