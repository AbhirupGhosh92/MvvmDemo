package com.happy.krutarthassignment.repository

import android.content.Context
import android.util.Log
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteDatabase
import com.happy.krutarthassignment.models.ResponseModel

@Database(
    entities = [ResponseModel::class],
    version = 3,
    exportSchema = false
)

@TypeConverters(CustomTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao() : UserDao

    companion object {
        private var INSTANCE : AppDatabase? = null

        private val lock = Any()

        fun getInstance(context: Context) : AppDatabase
        {
            if(INSTANCE == null)
            {
                synchronized(lock)
                {
                    INSTANCE = Room.databaseBuilder(context,AppDatabase::class.java,"AppDb.db")
                        .addCallback(object : RoomDatabase.Callback() {
                            override fun onCreate(db: SupportSQLiteDatabase) {
                                Log.d("AppDb.db", "Database created")
                                super.onCreate(db)
                            }

                            override fun onOpen(db: SupportSQLiteDatabase) {
                                Log.d("AppDb.db", "Database opened")
                                super.onOpen(db)
                            }
                        }).fallbackToDestructiveMigration()
                        .build()
                }
            }

            return INSTANCE!!
        }
    }

}