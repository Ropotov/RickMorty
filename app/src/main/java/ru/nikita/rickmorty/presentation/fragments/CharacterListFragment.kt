package ru.nikita.rickmorty.presentation.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import ru.nikita.rickmorty.RickAndMortyApp
import ru.nikita.rickmorty.databinding.FragmentCharacterListBinding
import javax.inject.Inject

class CharacterListFragment : Fragment() {

    private lateinit var binding: FragmentCharacterListBinding
    private lateinit var viewModel: CharacterListViewModel
    private val adapter by lazy {
        CharacterFragmentAdapter()
    }

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
        viewModel = ViewModelProvider(this, viewModelFactory)[CharacterListViewModel::class.java]
        binding = FragmentCharacterListBinding.inflate(inflater, container, false)
        rvInit()
        viewModel.characterLD.observe(viewLifecycleOwner) {
            adapter.submitList(it.results)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter.onCharacterClickListener = {
            findNavController().navigate(
                CharacterListFragmentDirections
                    .actionCharacterListFragmentToCharacterDetailFragment(it.id)
            )
        }
    }

    private fun rvInit() {
        val recyclerView = binding.rvCharacterList
        recyclerView.adapter = adapter
        val itemAnimator = binding.rvCharacterList.itemAnimator
        if (itemAnimator is DefaultItemAnimator) {
            itemAnimator.supportsChangeAnimations = false
        }
    }
}