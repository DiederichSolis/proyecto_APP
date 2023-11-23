package com.diederich.ecommerceappmvvm.di

import com.diederich.ecommerceappmvvm.data.datastore.AuthDatastore
import com.diederich.ecommerceappmvvm.data.repository.dataSource.AuthLocalDataSource
import com.diederich.ecommerceappmvvm.data.repository.dataSourceImpl.AuthLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)

object LocalDataModule {

    @Provides
    fun provideAuthLocalDataSource(authDatastore: AuthDatastore): AuthLocalDataSource = AuthLocalDataSourceImpl(authDatastore)
}