package ru.nikita.rickmorty.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.nikita.rickmorty.data.Result
import ru.nikita.rickmorty.databinding.ItemCharacterBinding

class CharacterFragmentAdapter :
    RecyclerView.Adapter<CharacterFragmentAdapter.CharacterViewHolder>() {

    var characterList: List<Result> = listOf()
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    class CharacterViewHolder(private val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Result) {
            binding.tvNameCharacter.text = position.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding =
            ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(characterList[position])
    }

    override fun getItemCount(): Int = characterList.size
}
