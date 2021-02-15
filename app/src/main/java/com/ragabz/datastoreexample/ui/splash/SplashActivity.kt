package com.ragabz.datastoreexample.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.activity.viewModels
import androidx.lifecycle.asLiveData
import com.ragabz.datastoreexample.R
import com.ragabz.datastoreexample.databinding.ActivitySplashBinding
import com.ragabz.datastoreexample.ui.home.MainActivity
import com.ragabz.datastoreexample.ui.onboarding.OnBoardingActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    val viewModel: SplashViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)

        setContentView(binding.root)
        viewModel.isOnBoardingDisabled.asLiveData().observe(this, {
            when {
                it == false -> {
                    // navigate to onBoarding screen
                    Handler().postDelayed(Runnable {
                        startActivity(Intent(this, OnBoardingActivity::class.java))
                        finish()
                    }, 300)
                }
                else -> {
                    // navigate to home screen
                    Handler().postDelayed(Runnable {
                        startActivity(Intent(this, MainActivity::class.java))
                        finish()
                    }, 300)

                }
            }
        })
    }
}