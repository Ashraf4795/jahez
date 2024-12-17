package com.jahez.home_data.repository

import com.jahez.home.HomePageContent
import kotlinx.coroutines.flow.Flow

interface IHomeRepository {
    fun fetchHomePageContent(): Flow<HomePageContent>
}