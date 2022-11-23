package ru.nikita.rickmorty.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModelProvider
import ru.nikita.rickmorty.R
import ru.nikita.rickmorty.RickAndMortyApp
import ru.nikita.rickmorty.presentation.fragments.CharacterListFragment
import ru.nikita.rickmorty.presentation.fragments.CharacterListViewModel
import ru.nikita.rickmorty.presentation.fragments.ViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private val component by lazy {
        (application as RickAndMortyApp).component
    }

    private lateinit var viewModel: CharacterListViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)[CharacterListViewModel::class.java]
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                viewModel.isLoading
            }
        }
        setContentView(R.layout.activity_main)
    }
}