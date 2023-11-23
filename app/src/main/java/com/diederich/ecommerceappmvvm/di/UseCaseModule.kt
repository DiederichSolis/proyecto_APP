package com.diederich.ecommerceappmvvm.di

import com.diederich.ecommerceappmvvm.data.repository.dataSource.AuthRemoteDataSource
import com.diederich.ecommerceappmvvm.data.repository.dataSourceImpl.AuthRemoteDataSourceImpl
import com.diederich.ecommerceappmvvm.data.service.AuthService
import com.diederich.ecommerceappmvvm.domain.repository.AuthRepository
import com.diederich.ecommerceappmvvm.domain.usecase.auth.AuthUseCase
import com.diederich.ecommerceappmvvm.domain.usecase.auth.LoginUseCase
import com.diederich.ecommerceappmvvm.domain.usecase.auth.RegisterUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)

object UseCaseModule {

    @Provides
    fun provideAuthUseCase(authRepository: AuthRepository) = AuthUseCase(
        login = LoginUseCase(authRepository),
        register = RegisterUseCase(authRepository)
    )
}