package ru.nikita.rickmorty.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import ru.nikita.rickmorty.R
import ru.nikita.rickmorty.databinding.FragmentCharacterListBinding

class CharacterListFragment : Fragment() {

    private lateinit var binding: FragmentCharacterListBinding
    private val adapter by lazy {
        CharacterFragmentAdapter()
    }
    private val viewModel: CharacterListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
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
                R.id.action_characterListFragment_to_characterDetailFragment
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