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
) : PagingDataAdapter<GalleryFileUiData, GalleryFileListAdapter.GalleryImageItemViewHolder>(
    object : DiffUtil.ItemCallback<GalleryFileUiData>() {
        override fun areItemsTheSame(oldItem: GalleryFileUiData, newItem: GalleryFileUiData): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: GalleryFileUiData, newItem: GalleryFileUiData): Boolean {
            return oldItem == newItem
        }
    }
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryImageItemViewHolder {
        val binding =
            ItemGalleryImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)

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
        private val onClick: (GalleryFileUiData) -> Unit
    ) : RecyclerView.ViewHolder(itemGalleryImageBinding.root) {

        fun bind(item: GalleryFileUiData) {
            itemGalleryImageBinding.root.setOnClickListener {
                onClick(item)
            }

            val image = Uri.parse(item.mediaData)
            itemGalleryImageBinding.ivGalleryImage.setImageURI(image)

            itemGalleryImageBinding.cvGalleryImageCount.isVisible = item.selectedNumber > 0
            itemGalleryImageBinding.tvGalleryImageCount.text = item.selectedNumber.toString()
            itemGalleryImageBinding.cvGalleryImageCover.isVisible = item.selectedNumber == 1

            itemGalleryImageBinding.galleryImage = item
            itemGalleryImageBinding.executePendingBindings()
        }
    }
}