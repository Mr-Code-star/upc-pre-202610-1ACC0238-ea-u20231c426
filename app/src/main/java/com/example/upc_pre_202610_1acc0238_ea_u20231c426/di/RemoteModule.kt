package com.example.upc_pre_202610_1acc0238_ea_u20231c426.di

import com.example.upc_pre_202610_1acc0238_ea_u20231c426.data.remote.BookService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {
    @Provides
    @Named("url")
    fun provideBaseUrl(): String {
        return "https://bookapp-gveteaa0dqf0eycn.eastus-01.azurewebsites.net/api/"
    }

    @Provides
    @Singleton
    fun provideRetrofit(@Named("url") url: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(url) // URL base de la api
            .addConverterFactory(GsonConverterFactory.create()) // // JSON → Kotlin
            .build()
    }

    @Provides
    @Singleton
    fun providedBooksService(retrofit: Retrofit): BookService {
        return retrofit.create(BookService::class.java)
    }

}