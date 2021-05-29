package com.dispy.searchgithubusers.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dispy.searchgithubusers.databinding.ActivityUserDetailBinding
import com.dispy.searchgithubusers.function.GithubCommandListener
import com.dispy.searchgithubusers.viewmodel.UserDetailViewModel

class UserDetailActivity : AppCompatActivity(), GithubCommandListener {

    private lateinit var binding: ActivityUserDetailBinding
    private lateinit var viewModel: UserDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        binding = ActivityUserDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent

        viewModel = UserDetailViewModel()
        viewModel.setGithubCommandListener(this)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        viewModel.getData(intent.getStringExtra("login")!!)

        binding.btnClose.setOnClickListener {
            finish()
        }
    }

    override fun showErrorMessage(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
    }
}