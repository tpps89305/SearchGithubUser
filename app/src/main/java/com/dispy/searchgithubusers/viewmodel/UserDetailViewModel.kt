package com.dispy.searchgithubusers.viewmodel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dispy.searchgithubusers.bean.User
import com.dispy.searchgithubusers.function.GithubCommand
import com.dispy.searchgithubusers.function.GithubCommandListener
import com.dispy.searchgithubusers.function.OnGithubUserDetailListener

class UserDetailViewModel {

    private val user: MutableLiveData<User> = MutableLiveData()
    private val progressBarVisibility: MutableLiveData<Int> = MutableLiveData()
    private lateinit var listener: GithubCommandListener

    fun setGithubCommandListener(listener: GithubCommandListener) {
        this@UserDetailViewModel.listener = listener
    }

    fun getUser(): LiveData<User> {
        return user
    }

    fun getProgressBarVisibility(): LiveData<Int> {
        return progressBarVisibility
    }

    fun getData(login: String) {
        this@UserDetailViewModel.progressBarVisibility.value = View.VISIBLE
        GithubCommand().getUserDetail(login, object : OnGithubUserDetailListener {
            override fun onSuccess(result: User) {
                this@UserDetailViewModel.user.value = result
                this@UserDetailViewModel.progressBarVisibility.value = View.GONE
            }

            override fun onFailure(message: String) {
                this@UserDetailViewModel.progressBarVisibility.value = View.GONE
                listener.showErrorMessage(message)
            }

        })
    }

}