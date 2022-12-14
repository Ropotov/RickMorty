package ru.nikita.rickmorty.presentation.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import ru.nikita.rickmorty.RickAndMortyApp
import ru.nikita.rickmorty.databinding.FragmentCharacterDetailBinding
import javax.inject.Inject

class CharacterDetailFragment : Fragment() {

    private val args by navArgs<CharacterDetailFragmentArgs>()
    private lateinit var binding: FragmentCharacterDetailBinding
    private lateinit var viewModel: CharacterDetailViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val component by lazy {
        (requireActivity().application as RickAndMortyApp).component
    }

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this, viewModelFactory)[CharacterDetailViewModel::class.java]
        binding = FragmentCharacterDetailBinding.inflate(inflater, container, false)
        viewModel.getDetailCharacter(args.id)
        viewModel.characterDetailLD.observe(viewLifecycleOwner) {
            binding.tvNameCharacterDetail.text = it.name
            binding.tvCharacterRaceDetail.text = it.species
            binding.tvStatusDetail.text = it.status
            binding.tvGenderDetail.text = it.gender
            binding.tvLastLocationDetail.text = it.location.name
            Glide.with(binding.ivDetailCharacter)
                .load(it.image)
                .into(binding.ivDetailCharacter)
        }
        return binding.root
    }
}