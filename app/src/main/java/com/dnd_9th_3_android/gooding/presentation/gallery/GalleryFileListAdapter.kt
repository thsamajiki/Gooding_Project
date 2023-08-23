package com.dnd_9th_3_android.gooding.presentation.gallery

import android.graphics.drawable.GradientDrawable
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dnd_9th_3_android.gooding.R
import com.dnd_9th_3_android.gooding.databinding.ItemGalleryImageBinding
import com.dnd_9th_3_android.gooding.presentation.util.fromDpToPx

class GalleryFileListAdapter(
    private val onClick: (GalleryFileUiData) -> Unit,
    private val isFullSelected: () -> Boolean,
) : PagingDataAdapter<GalleryFileUiData, GalleryFileListAdapter.GalleryFileItemViewHolder>(
    object : DiffUtil.ItemCallback<GalleryFileUiData>() {
        override fun areItemsTheSame(
            oldItem: GalleryFileUiData,
            newItem: GalleryFileUiData
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: GalleryFileUiData,
            newItem: GalleryFileUiData
        ): Boolean {
            return oldItem == newItem
        }
    }
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryFileItemViewHolder {
        val binding =
            ItemGalleryImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return GalleryFileItemViewHolder(binding, isFullSelected, onClick)
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
        private val isFullSelected: () -> Boolean,
        private val onClick: (GalleryFileUiData) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.strokeView.background =
                GradientDrawable().apply {
                    setStroke(
                        1.5f.fromDpToPx(),
                        ContextCompat.getColor(itemView.context, R.color.primaryColor)
                    )
                }
        }

        fun bind(item: GalleryFileUiData) {
            binding.root.setOnClickListener {
                onClick(item)
            }

            binding.strokeView.isVisible = item.isSelected
            val image = Uri.parse(item.mediaData)

            Glide.with(itemView.context)
                .load(image)
                .into(binding.ivGalleryImage)

            binding.tvGalleryImageCount.isVisible = item.selectedNumber > 0
            binding.tvGalleryImageCount.text = item.selectedNumber.toString()
            binding.imageCover.isVisible = item.selectedNumber == 1

            binding.dimView.isVisible = isFullSelected() && !item.isSelected

            binding.galleryImage = item
            binding.executePendingBindings()
        }
    }
}