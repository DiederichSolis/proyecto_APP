package com.diederich.ecommerceappmvvm.di

import com.diederich.ecommerceappmvvm.data.repository.dataSource.AuthRemoteDataSource
import com.diederich.ecommerceappmvvm.data.repository.dataSourceImpl.AuthRemoteDataSourceImpl
import com.diederich.ecommerceappmvvm.data.service.AuthService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)

object RemoteDataModule {

    @Provides
    fun provideAuthRemoteDathSource(authService: AuthService): AuthRemoteDataSource = AuthRemoteDataSourceImpl(authService)
}