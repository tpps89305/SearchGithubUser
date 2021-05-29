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
        supportActionBar!!.hide()
        binding = ActivityUserDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent

        viewModel = UserDetailViewModel()
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        viewModel.getData(intent.getStringExtra("login")!!)

        binding.btnClose.setOnClickListener {
            finish()
        }
    }
}