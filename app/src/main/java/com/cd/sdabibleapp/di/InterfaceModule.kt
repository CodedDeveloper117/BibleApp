package com.cd.sdabibleapp.di

import com.cd.sdabibleapp.data.repositories.BibleRepositoryImpl
import com.cd.sdabibleapp.domain.repositories.BibleRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class InterfaceModule {
    @Binds
    abstract fun bindMusicRepository(
        impl: BibleRepositoryImpl
    ): BibleRepository
}