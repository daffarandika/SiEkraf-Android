package org.app.siekraf.feature_home.data

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class HomeRepositoryModule {
    @Binds
    @Singleton
    abstract fun bindRepo(
        networkHomeRepository: NetworkHomeRepository
    ): HomeRepository
}