package com.jahez.home_data.datasource.remote

import com.jahez.home.HomePageContent
import javax.inject.Inject

class HomeRemoteDataSource @Inject constructor(): IHomeRemoteDataSource {
    override suspend fun fetchHomePageContent(): HomePageContent {
        return HomePageContent(
            id = "",
            offersWidget = null,
            merchantsWidget = null
        )
    }
}