package com.dnd_9th_3_android.gooding.data.model.map

import android.os.Parcelable
import com.dnd_9th_3_android.gooding.presentation.record.search.Location
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class KakaoMapDocuments(
    @SerializedName("address_name") val addressName: String?,
    @SerializedName("category_group_code") val categoryGroupCode: String?,
    @SerializedName("category_group_name") val categoryGroupName: String?,
    @SerializedName("category_name") val categoryName: String?,
    @SerializedName("distance") val distance: String?,
    @SerializedName("id") val id: String?,
    @SerializedName("phone") val phone: String?,
    @SerializedName("place_name") val placeName: String?,
    @SerializedName("place_url") val placeUrl: String?,
    @SerializedName("road_address_name") val roadAddressName: String?,
    @SerializedName("x") val x: String?,
    @SerializedName("y") val y: String?,
    val currentLocation: Location? = null
) : Parcelable