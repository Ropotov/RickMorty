package ru.nikita.rickmorty.presentation.fragments

import android.graphics.Color
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.nikita.rickmorty.databinding.ItemCharacterBinding
import ru.nikita.rickmorty.domain.model.Result
import ru.nikita.rickmorty.utils.CharacterStatusEnums

class CharacterViewHolder(val binding: ItemCharacterBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(position: Result) {
        with(binding) {
            tvNameCharacter.text = position.name
            tvCharacterRace.text = position.species
            tvLastLocation.text = position.location.name
            when (position.status) {
                CharacterStatusEnums.CHARACTER_ALIVE.value ->
                    tvStatusColor.setBackgroundColor(Color.parseColor("#02B31A"))
                CharacterStatusEnums.CHARACTER_DEAD.value ->
                    tvStatusColor.setBackgroundColor(Color.parseColor("#FF0800"))
                else ->
                    tvStatusColor.setBackgroundColor(Color.parseColor("#E3E3E3"))
            }
            Glide
                .with(ivCharacterPhoto)
                .load(position.image)
                .into(ivCharacterPhoto)
        }
    }
}