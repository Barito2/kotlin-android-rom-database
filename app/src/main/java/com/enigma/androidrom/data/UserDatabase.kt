package com.enigma.androidrom.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDatabase: RoomDatabase() {

    abstract fun dao(): UserDao

    companion object {
        @Volatile
        private var INTANCE: UserDatabase? = null

        fun getDatabase(context: Context): UserDatabase {
//            cara panjang
//            val tempInstance = INTANCE
//            if (tempInstance != null) {
//                return tempInstance
//            }
//
//            synchronized(this) {
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    UserDatabase::class.java,
//                    "user_database"
//                ).build()
//                INTANCE = instance
//                return instance
//            }

//            cara kotlin
            return INTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "user_database"
                ).build()
                INTANCE = instance
                instance
            }
        }
    }
}