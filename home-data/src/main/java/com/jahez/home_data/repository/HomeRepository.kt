package com.jahez.home_data.repository

import com.jahez.core.Fake
import com.jahez.data_model.RemoteMerchant
import com.jahez.home.HomePageContent
import com.jahez.home_data.datasource.local.IHomeLocalDataSource
import com.jahez.home_data.datasource.remote.IHomeRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class HomeRepository @Inject constructor(
    @Fake private val homeRemoteDataSource: IHomeRemoteDataSource,
    private val homeLocalDataSource: IHomeLocalDataSource
) : IHomeRepository {

    override fun fetchHomePageContent(): Flow<HomePageContent> {
        return flow {
            emit(homeRemoteDataSource.fetchHomePageContent())
        }
    }

}