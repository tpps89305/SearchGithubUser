package com.dispy.searchgithubusers.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.dispy.searchgithubusers.databinding.ActivityMainBinding
import com.dispy.searchgithubusers.viewmodel.SearchUserViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val userAdapter: UserAdapter = UserAdapter(this, ArrayList())
    private lateinit var searchUserViewModel: SearchUserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val linearLayoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL, false
        )
        binding.recyclerView.layoutManager = linearLayoutManager
        binding.recyclerView.adapter = userAdapter

        searchUserViewModel = SearchUserViewModel()
        binding.viewModel = searchUserViewModel
        searchUserViewModel.getUsers().observe(this,
            { data ->
                userAdapter.removeItems()
                userAdapter.swapItems(data)
            }
        )

        binding.editSearch.addTextChangedListener(
            afterTextChanged = {
                Log.d("MainActivity", "it text = ${it.toString()}")
                if (!TextUtils.isEmpty(it.toString())) {
                    searchUserViewModel.searchUsers(it.toString())
                }
            }
        )

    }
}