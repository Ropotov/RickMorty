package ru.nikita.rickmorty.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.RecyclerView
import ru.nikita.rickmorty.databinding.FragmentCharacterListBinding

class CharacterListFragment : Fragment() {

    private lateinit var binding: FragmentCharacterListBinding
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: CharacterFragmentAdapter
    private val viewModel: CharacterListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharacterListBinding.inflate(inflater, container, false)
        rvInit()
        viewModel.characterList.observe(viewLifecycleOwner, {
        })
        return binding.root
    }

    private fun rvInit() {
        recyclerView = binding.rvCharacterList
        adapter = CharacterFragmentAdapter()
        recyclerView.adapter = adapter
        val itemAnimator = binding.rvCharacterList.itemAnimator
        if (itemAnimator is DefaultItemAnimator) {
            itemAnimator.supportsChangeAnimations = false
        }
    }
}