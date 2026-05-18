package com.example.upc_pre_202610_1acc0238_ea_u20231c426.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [BookEntity::class],
    version = 1
)
abstract class AppDataBase: RoomDatabase() {
    abstract fun bookDao(): BookDao
}