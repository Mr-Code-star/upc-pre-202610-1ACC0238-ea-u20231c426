package com.example.upc_pre_202610_1acc0238_ea_u20231c426.di

import androidx.room.Room
import com.example.upc_pre_202610_1acc0238_ea_u20231c426.MyApplication
import com.example.upc_pre_202610_1acc0238_ea_u20231c426.data.local.AppDataBase
import com.example.upc_pre_202610_1acc0238_ea_u20231c426.data.local.BookDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object LocalModule {
    @Provides
    @Singleton
    fun provideDataBase(): AppDataBase {
        return Room.databaseBuilder(
            MyApplication.instance.applicationContext, // contexto de la app
            AppDataBase::class.java, // clase de la base de datos
            "book_db" // nombre del archivo en el celular
        ).build()
    }

    @Provides
    @Singleton
    fun provideEvents(dataBase: AppDataBase): BookDao {
        return dataBase.bookDao()
    }

}