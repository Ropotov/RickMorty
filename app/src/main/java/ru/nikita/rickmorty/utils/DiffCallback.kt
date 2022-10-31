package ru.nikita.rickmorty.utils

import androidx.recyclerview.widget.DiffUtil
import ru.nikita.rickmorty.domain.model.Result

class DiffCallback() : DiffUtil.ItemCallback<Result>() {
    override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
        return oldItem == newItem
    }
}