package com.jahez.home_data.datasource.remote.firebase

import com.jahez.home.HomePageContent
import com.jahez.home_data.datasource.remote.IHomeRemoteDataSource
import javax.inject.Inject

class HomeFirebaseDataSource @Inject constructor(
    //private val firebase: Firebase
): IHomeRemoteDataSource {
    override suspend fun fetchHomePageContent(): HomePageContent {
        return HomePageContent(
            id = "",
            offersWidget = null,
            merchantsWidget = null
        )
    }
}