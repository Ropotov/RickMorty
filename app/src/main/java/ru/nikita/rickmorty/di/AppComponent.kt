package ru.nikita.rickmorty.di

import dagger.Component
import ru.nikita.rickmorty.presentation.MainActivity
import ru.nikita.rickmorty.presentation.fragments.CharacterDetailFragment
import ru.nikita.rickmorty.presentation.fragments.CharacterListFragment

@ApplicationScope
@Component(
    modules = [DataModule::class, ViewModelModule::class]
)
interface AppComponent {

    fun inject(fragment: CharacterListFragment)
    fun inject(fragment: CharacterDetailFragment)
    fun inject(activity: MainActivity)
}