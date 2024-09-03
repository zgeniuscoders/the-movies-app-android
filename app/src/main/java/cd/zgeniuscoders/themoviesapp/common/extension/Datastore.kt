package cd.zgeniuscoders.themoviesapp.common.extension

import android.content.Context
import androidx.datastore.dataStore
import cd.zgeniuscoders.themoviesapp.common.AppSettingsSerializer

val Context.dataStore by dataStore("user-settings.js", AppSettingsSerializer)