package com.dnd_9th_3_android.gooding.presentation.record.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dnd_9th_3_android.gooding.data.model.map.KakaoMapDocuments
import com.dnd_9th_3_android.gooding.databinding.ItemKakaoMapPlaceBinding
import kotlin.math.asin
import kotlin.math.cos
import kotlin.math.round
import kotlin.math.sin
import kotlin.math.sqrt

class GoodieDayPlaceListAdapter(
    private val onClick: (KakaoMapDocuments) -> Unit,
) : ListAdapter<KakaoMapDocuments, GoodieDayPlaceListAdapter.GoodieDayPlaceViewHolder>(DiffCallback()) {

    class GoodieDayPlaceViewHolder(
        val binding: ItemKakaoMapPlaceBinding,
        private val onClick: (KakaoMapDocuments) -> Unit,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(mapData: KakaoMapDocuments) {
            binding.tvPlaceName.text = mapData.placeName
            binding.tvPlaceDistance.text = formatDistance(
                calculateDistance(
                    mapData.currentLocation ?: return,
                    Location(mapData.y?.toDoubleOrNull() ?: 0.0, mapData.x?.toDoubleOrNull() ?: 0.0)
                )
            )
            binding.tvPlaceAddress.text = mapData.addressName

            binding.root.setOnClickListener {
                onClick(mapData)
            }
        }

        private fun calculateDistance(currentLocation: Location, targetLocation: Location): Double {
            val earthRadiusKm = 6371.0

            val deltaLatitude = Math.toRadians(targetLocation.latitude - currentLocation.latitude)
            val deltaLongitude =
                Math.toRadians(targetLocation.longitude - currentLocation.longitude)

            val a = sin(deltaLatitude / 2) * sin(deltaLatitude / 2) +
                    cos(Math.toRadians(currentLocation.latitude)) * cos(
                Math.toRadians(
                    targetLocation.latitude
                )
            ) *
                    sin(deltaLongitude / 2) * sin(deltaLongitude / 2)
            val c = 2 * asin(sqrt(a))

            return earthRadiusKm * c
        }

        fun formatDistance(distance: Double): String {
            val roundedDistance = round(distance * 10) / 10
            return "$roundedDistance km"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoodieDayPlaceViewHolder {
        val binding =
            ItemKakaoMapPlaceBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return GoodieDayPlaceViewHolder(binding, onClick)
    }

    override fun onBindViewHolder(holder: GoodieDayPlaceViewHolder, position: Int) {
        val mapItem = currentList[position]

        holder.bind(mapItem)
    }

    override fun getItemCount(): Int {
        return currentList.size
    }

    private class DiffCallback : DiffUtil.ItemCallback<KakaoMapDocuments>() {
        override fun areItemsTheSame(oldItem: KakaoMapDocuments, newItem: KakaoMapDocuments): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: KakaoMapDocuments, newItem: KakaoMapDocuments): Boolean {
            return oldItem == newItem
        }
    }
}