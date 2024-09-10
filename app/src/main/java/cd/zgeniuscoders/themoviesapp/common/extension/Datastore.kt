package cd.zgeniuscoders.themoviesapp.common.extension

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import cd.zgeniuscoders.themoviesapp.common.AppSettingsSerializer

val Context.dataStore by dataStore("user-settings.js", AppSettingsSerializer)
val Context.preferences: DataStore<Preferences> by preferencesDataStore(name = "user-settings")