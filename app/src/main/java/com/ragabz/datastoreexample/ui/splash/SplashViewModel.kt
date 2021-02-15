package com.ragabz.datastoreexample.ui.splash

import androidx.lifecycle.ViewModel
import com.ragabz.datastoreexample.PrefStoreImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val prefStoreImpl: PrefStoreImpl
) : ViewModel() {
    val isOnBoardingDisabled = prefStoreImpl.isOnBoardingDisabled
}