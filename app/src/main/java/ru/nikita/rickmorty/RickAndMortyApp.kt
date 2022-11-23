package ru.nikita.rickmorty

import android.app.Application
import ru.nikita.rickmorty.di.DaggerAppComponent

class RickAndMortyApp : Application() {

    val component by lazy {
        DaggerAppComponent.create()
    }
}