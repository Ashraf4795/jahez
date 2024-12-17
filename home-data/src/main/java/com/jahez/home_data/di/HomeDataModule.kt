package com.jahez.home_data.di

import com.jahez.core.Fake
import com.jahez.core.Real
import com.jahez.home_data.datasource.local.HomeLocalDataSource
import com.jahez.home_data.datasource.local.IHomeLocalDataSource
import com.jahez.home_data.datasource.remote.HomeRemoteDataSource
import com.jahez.home_data.datasource.remote.IHomeRemoteDataSource
import com.jahez.home_data.datasource.remote.fake.FakeHomeRemoteDataSource
import com.jahez.home_data.repository.HomeRepository
import com.jahez.home_data.repository.IHomeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface HomeDataModule {
    @Binds
    @Fake
    fun bindsHomeRemoteDataSource(homeDataSource: FakeHomeRemoteDataSource): IHomeRemoteDataSource

    @Binds
    @Real
    fun bindsHomeRemoteDataSourceImpl(homeDataSource: HomeRemoteDataSource): IHomeRemoteDataSource

    @Binds
    fun bindsHomeLocalDataSource(homeDataSource: HomeLocalDataSource): IHomeLocalDataSource

    @Binds
    fun bindsHomeRepository(homeRepository: HomeRepository): IHomeRepository
}