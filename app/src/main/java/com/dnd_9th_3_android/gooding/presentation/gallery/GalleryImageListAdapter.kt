package com.dnd_9th_3_android.gooding.presentation.gallery

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.dnd_9th_3_android.gooding.data.model.gallery.GalleryImageData
import com.dnd_9th_3_android.gooding.databinding.ItemGalleryImageBinding

class GalleryImageListAdapter(
    private val onClick: (GalleryImageData) -> Unit
) : PagingDataAdapter<GalleryImageData, GalleryImageListAdapter.GalleryImageItemViewHolder>(
    object : DiffUtil.ItemCallback<GalleryImageData>() {
        override fun areItemsTheSame(oldItem: GalleryImageData, newItem: GalleryImageData): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: GalleryImageData, newItem: GalleryImageData): Boolean {
            return oldItem == newItem
        }
    }
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryImageItemViewHolder {
        val binding = ItemGalleryImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return GalleryImageItemViewHolder(binding, onClick)
    }

    override fun onBindViewHolder(holder: GalleryImageItemViewHolder, position: Int) {
        getItem(position).let {
            if (it != null) {
                holder.bind(it)
            }
        }
    }

    class GalleryImageItemViewHolder(
        private val itemGalleryImageBinding: ItemGalleryImageBinding,
        private val onClick: (GalleryImageData) -> Unit
    ) : RecyclerView.ViewHolder(itemGalleryImageBinding.root) {

        fun bind(item: GalleryImageData) {
            itemGalleryImageBinding.root.setOnClickListener {
                onClick(item)
            }
            itemGalleryImageBinding.galleryImage = item
            itemGalleryImageBinding.executePendingBindings()
        }
    }
}