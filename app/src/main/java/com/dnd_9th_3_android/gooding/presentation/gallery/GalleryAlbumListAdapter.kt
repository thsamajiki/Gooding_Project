package com.dnd_9th_3_android.gooding.presentation.gallery

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dnd_9th_3_android.gooding.databinding.ItemGalleryAlbumBinding


class GalleryAlbumListAdapter(
    private val onClick: (GalleryAlbumUiData) -> Unit
) : ListAdapter<GalleryAlbumUiData, GalleryAlbumListAdapter.AlbumViewHolder>(object :
    DiffUtil.ItemCallback<GalleryAlbumUiData>() {
    override fun areItemsTheSame(oldItem: GalleryAlbumUiData, newItem: GalleryAlbumUiData): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: GalleryAlbumUiData, newItem: GalleryAlbumUiData): Boolean {
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
        private val onClick: (GalleryAlbumUiData) -> Unit
    ) :
        RecyclerView.ViewHolder(
            ItemGalleryAlbumBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ).root
        ) {
        private val binding = ItemGalleryAlbumBinding.bind(itemView)

        fun bind(item: GalleryAlbumUiData) {
            binding.root.setOnClickListener {
                onClick(item)
            }

            binding.ivAlbumImage.setImageURI(item.thumbnail)
            binding.title.text = item.name
            binding.subtitle.text = item.count.toString()
        }
    }
}

