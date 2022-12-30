package com.cashflow.room.mvvm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.room.mvvm.R
import com.example.room.mvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        window.navigationBarColor = ContextCompat.getColor(this, R.color.colorPrimary)
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimary)

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}