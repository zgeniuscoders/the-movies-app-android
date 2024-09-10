package cd.zgeniuscoders.themoviesapp.users.domain.use_cases

import cd.zgeniuscoders.themoviesapp.common.UserSettings
import cd.zgeniuscoders.themoviesapp.users.domain.services.UserService

class SaveUserPref(
    private val userService: UserService
) {

    suspend fun run(userSettings: UserSettings) {
        return userService.saveUserInPref(userSettings)
    }


}