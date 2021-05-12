package com.example.testappp.di

import com.example.testappp.data.local.LocalDataRepository
import com.example.testappp.data.repository.DataRepository
import com.example.testappp.data.service.Api
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@InstallIn(ActivityRetainedComponent::class)
@Module
object ReposityoryModelModule {

    @Provides
    fun providesDataRepo(apiService: Api,localDataRepository: LocalDataRepository): DataRepository {
        return DataRepository(apiService,localDataRepository)
    }
}