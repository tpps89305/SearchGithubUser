package com.dispy.searchgithubusers.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dispy.searchgithubusers.databinding.ActivityUserDetailBinding
import com.dispy.searchgithubusers.viewmodel.UserDetailViewModel

class UserDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserDetailBinding
    private lateinit var viewModel: UserDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val intent = intent

        viewModel = UserDetailViewModel()
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        viewModel.getData(intent.getStringExtra("login")!!)
    }
}