package ru.nikita.rickmorty.fragments

import android.graphics.Color
import android.sax.EndElementListener
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.nikita.rickmorty.data.Result
import ru.nikita.rickmorty.databinding.ItemCharacterBinding
import ru.nikita.rickmorty.utils.CharacterStatusEnums

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
