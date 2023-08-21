package com.dnd_9th_3_android.gooding.presentation.gallery

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dnd_9th_3_android.gooding.databinding.ItemAlbumBinding


class AlbumListAdapter(
    private val onClick: (AlbumUiData) -> Unit
) : ListAdapter<AlbumUiData, AlbumListAdapter.AlbumViewHolder>(object :
    DiffUtil.ItemCallback<AlbumUiData>() {
    override fun areItemsTheSame(oldItem: AlbumUiData, newItem: AlbumUiData): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: AlbumUiData, newItem: AlbumUiData): Boolean {
        return oldItem == newItem
    }
}) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        return AlbumViewHolder(parent, onClick)
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class AlbumViewHolder(
        parent: ViewGroup,
        private val onClick: (AlbumUiData) -> Unit
    ) :
        RecyclerView.ViewHolder(
            ItemAlbumBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ).root
        ) {
        private val binding = ItemAlbumBinding.bind(itemView)

        fun bind(item: AlbumUiData) {
            binding.root.setOnClickListener {
                onClick(item)
            }

            binding.ivAlbumImage.setImageURI(item.thumbnail)
            binding.title.text = item.name
            binding.subtitle.text = item.count.toString()
        }
    }
}

