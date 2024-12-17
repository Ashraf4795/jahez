package com.jahez.home_data.datasource.remote.fake

import com.jahez.common.DeliveryMetadata
import com.jahez.common.LocalizedContent
import com.jahez.common.Rate
import com.jahez.data_model.RemoteMerchant
import com.jahez.home.HomePageContent
import com.jahez.home.OffersWidget
import com.jahez.home_data.datasource.remote.IHomeRemoteDataSource
import javax.inject.Inject

class FakeHomeRemoteDataSource @Inject constructor(): IHomeRemoteDataSource {
    override suspend fun fetchHomePageContent(): HomePageContent {
        return fakeHomePageContent
    }
}