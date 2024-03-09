package com.rachellima.lookingmovies

import com.rachellima.lookingmovies.di.appModule
import org.junit.Test
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.test.KoinTest
import org.koin.test.verify.verify

class KoinModulesTest : KoinTest {
    @OptIn(KoinExperimentalAPI::class)
    @Test
    fun checkAllModules() {
        appModule.verify(
            extraTypes = getAllowedListTypes()
        )
    }

    private fun getAllowedListTypes() = listOf(
        androidx.lifecycle.SavedStateHandle::class
    )
}