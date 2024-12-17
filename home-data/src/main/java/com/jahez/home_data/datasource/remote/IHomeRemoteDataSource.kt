package com.jahez.home_data.datasource.remote

import com.jahez.home.HomePageContent

interface IHomeRemoteDataSource {
    suspend fun fetchHomePageContent(): HomePageContent
}