package com.dnd_9th_3_android.gooding.presentation.record

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dnd_9th_3_android.gooding.databinding.ItemRecordImageVideoFileBinding
import com.dnd_9th_3_android.gooding.presentation.gallery.GalleryFileUiData

class RecordImageVideoListAdapter(
    private val onClick: (GalleryFileUiData) -> Unit
): ListAdapter<GalleryFileUiData, RecordImageVideoListAdapter.RecordImageVideoItemViewHolder>(
    object : DiffUtil.ItemCallback<GalleryFileUiData>() {
        override fun areItemsTheSame(oldItem: GalleryFileUiData, newItem: GalleryFileUiData): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: GalleryFileUiData, newItem: GalleryFileUiData): Boolean {
            return oldItem == newItem
        }
    }
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecordImageVideoItemViewHolder {
        val binding =
            ItemRecordImageVideoFileBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return RecordImageVideoItemViewHolder(binding, onClick)
    }

    override fun onBindViewHolder(holder: RecordImageVideoItemViewHolder, position: Int) {
        getItem(position).let {
            if (it != null) {
                holder.bind(it)
            }
        }
    }

    class RecordImageVideoItemViewHolder(
        private val binding: ItemRecordImageVideoFileBinding,
        private val onClick: (GalleryFileUiData) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: GalleryFileUiData) {
            binding.root.setOnClickListener {
                onClick(item)
            }

            binding.ivDeleteFile.setOnClickListener {

            }
        }
    }
}