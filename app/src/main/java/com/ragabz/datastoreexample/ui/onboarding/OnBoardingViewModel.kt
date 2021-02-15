package com.ragabz.datastoreexample.ui.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ragabz.datastoreexample.PrefStoreImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val prefStoreImpl: PrefStoreImpl
) : ViewModel() {

    val isOnBoardingDisabled = prefStoreImpl.isOnBoardingDisabled
    fun hideOnBoarding() {
        viewModelScope.launch {
            prefStoreImpl.disableOnBoarding()
        }
    }
}