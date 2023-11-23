package com.diederich.ecommerceappmvvm.di

import com.diederich.ecommerceappmvvm.data.repository.AuthRepositoryImpl
import com.diederich.ecommerceappmvvm.data.repository.dataSource.AuthLocalDataSource
import com.diederich.ecommerceappmvvm.data.repository.dataSource.AuthRemoteDataSource
import com.diederich.ecommerceappmvvm.data.repository.dataSourceImpl.AuthRemoteDataSourceImpl
import com.diederich.ecommerceappmvvm.data.service.AuthService
import com.diederich.ecommerceappmvvm.domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)

object RepositoryModule {

    @Provides
    fun provideAuthRepository(
        authRemoteDataSource: AuthRemoteDataSource,
        authLocalDataSource: AuthLocalDataSource
    ): AuthRepository = AuthRepositoryImpl(authRemoteDataSource,authLocalDataSource)
}