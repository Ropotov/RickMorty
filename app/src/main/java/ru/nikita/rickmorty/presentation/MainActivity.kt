package ru.nikita.rickmorty.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import ru.nikita.rickmorty.R
import ru.nikita.rickmorty.presentation.fragments.CharacterListFragment
import ru.nikita.rickmorty.presentation.fragments.CharacterListViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: CharacterListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                viewModel.isLoading
            }
        }
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.container, CharacterListFragment())
                .commit()
        }
    }
}