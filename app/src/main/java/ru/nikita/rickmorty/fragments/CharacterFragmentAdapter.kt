package ru.nikita.rickmorty.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ru.nikita.rickmorty.data.Result
import ru.nikita.rickmorty.databinding.ItemCharacterBinding
import ru.nikita.rickmorty.utils.DiffCallback

class CharacterFragmentAdapter : ListAdapter<Result, CharacterViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding =
            ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
