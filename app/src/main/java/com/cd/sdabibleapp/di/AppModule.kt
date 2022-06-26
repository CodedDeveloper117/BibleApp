package com.cd.sdabibleapp.di

import android.content.Context
import androidx.room.Room
import com.cd.sdabibleapp.data.api.WebClient
import com.cd.sdabibleapp.data.api.WebClientConfiguration
import com.cd.sdabibleapp.data.database.BibleDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideRoomDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        BibleDatabase::class.java,
        "bible_database"
    ).fallbackToDestructiveMigration()
        .build()

    @Singleton
    @Provides
    fun provideBibleDao(database: BibleDatabase) = database.dao

    @Singleton
    @Provides
    fun provideHttpClient() = WebClientConfiguration.httpClient

    @Singleton
    @Provides
    fun provideNewsApi(client: HttpClient) = WebClient(client)
}