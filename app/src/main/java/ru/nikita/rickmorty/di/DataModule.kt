package ru.nikita.rickmorty.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.nikita.rickmorty.data.CharacterRepositoryImpl
import ru.nikita.rickmorty.data.api.ApiService
import ru.nikita.rickmorty.data.api.RetrofitInstance
import ru.nikita.rickmorty.domain.CharacterRepository

@Module
interface DataModule {

    @Binds
    @ApplicationScope
    fun bindCharacterRepository(impl: CharacterRepositoryImpl): CharacterRepository

    companion object{

        @Provides
        @ApplicationScope
        fun provideApiService(): ApiService{
           return RetrofitInstance.Api
        }
    }
}