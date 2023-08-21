package com.dnd_9th_3_android.gooding.presentation.gallery

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.dnd_9th_3_android.gooding.databinding.ItemGalleryImageBinding

class GalleryFileListAdapter(
    private val onClick: (GalleryFileUiData) -> Unit
) : PagingDataAdapter<GalleryFileUiData, GalleryFileListAdapter.GalleryFileItemViewHolder>(
    object : DiffUtil.ItemCallback<GalleryFileUiData>() {
        override fun areItemsTheSame(oldItem: GalleryFileUiData, newItem: GalleryFileUiData): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: GalleryFileUiData, newItem: GalleryFileUiData): Boolean {
            return oldItem == newItem
        }
    }
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryFileItemViewHolder {
        val binding =
            ItemGalleryImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return GalleryFileItemViewHolder(binding, onClick)
    }

    override fun onBindViewHolder(holder: GalleryFileItemViewHolder, position: Int) {
        getItem(position).let {
            if (it != null) {
                holder.bind(it)
            }
        }
    }

    class GalleryFileItemViewHolder(
        private val binding: ItemGalleryImageBinding,
        private val onClick: (GalleryFileUiData) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: GalleryFileUiData) {
            binding.root.setOnClickListener {
                onClick(item)
            }

            val image = Uri.parse(item.mediaData)
            binding.ivGalleryImage.setImageURI(image)

            binding.cvGalleryImageCount.isVisible = item.selectedNumber > 0
            binding.tvGalleryImageCount.text = item.selectedNumber.toString()
            binding.cvGalleryImageCover.isVisible = item.selectedNumber == 1

            binding.galleryImage = item
            binding.executePendingBindings()
        }
    }
}