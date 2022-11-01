package ru.nikita.rickmorty.presentation.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ru.nikita.rickmorty.databinding.ItemCharacterBinding
import ru.nikita.rickmorty.domain.model.Result
import ru.nikita.rickmorty.utils.DiffCallback

class CharacterFragmentAdapter : ListAdapter<Result, CharacterViewHolder>(DiffCallback()) {

    var onCharacterClickListener: ((Result) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding =
            ItemCharacterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val characterPosition = getItem(position)
        holder.bind(characterPosition)
        holder.binding.root.setOnClickListener {
            onCharacterClickListener?.invoke(characterPosition)
        }
    }
}
