package com.example.upc_pre_202610_1acc0238_ea_u20231c426.di

import com.example.upc_pre_202610_1acc0238_ea_u20231c426.data.repository.BookRepositoryImpl
import com.example.upc_pre_202610_1acc0238_ea_u20231c426.domain.repositories.BookRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface RepositoryModule {
    @Binds
    fun provideEventRepository(impl: BookRepositoryImpl): BookRepository
}