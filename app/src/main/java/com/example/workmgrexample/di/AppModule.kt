package com.example.workmgrexample.di

import android.content.Context
import com.example.workmgrexample.CustomWorkerFactory
import com.example.workmgrexample.repository.TestRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
 /*   @Singleton
    @Provides
    fun provideTestRepository(@ApplicationContext context: Context) =
        TestRepository()

    @Singleton
    @Provides
    fun provideCustomWorkerFactory(testRepository: TestRepository) =
        CustomWorkerFactory(testRepository)*/
}