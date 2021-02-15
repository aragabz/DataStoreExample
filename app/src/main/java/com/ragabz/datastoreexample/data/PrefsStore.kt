package com.ragabz.datastoreexample

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.createDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PrefStoreImpl @Inject constructor(@ApplicationContext context: Context) {

    private val dataStore: DataStore<Preferences> =
        context.createDataStore(name = PreferencesKeys.PREF_NAME)


    val isOnBoardingDisabled: Flow<Boolean> = dataStore.data.catch { exception ->
        if (exception is IOException) {
            Log.v("PrefStoreImpl", exception.toString())
            emit(emptyPreferences())
        } else {
            throw exception
        }
    }.map { settings ->
        settings[PreferencesKeys.isOnBoardingDisabled] ?: false
    }

    suspend fun disableOnBoarding() {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.isOnBoardingDisabled] = true
        }
    }
    private object PreferencesKeys {
        val isOnBoardingDisabled = booleanPreferencesKey("show_onBoarding")
        const val PREF_NAME = "settings"
    }
}


