package com.ragabz.datastoreexample.ui.home

import androidx.lifecycle.ViewModel
import com.ragabz.datastoreexample.PrefStoreImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val prefStoreImpl: PrefStoreImpl
): ViewModel() {



}