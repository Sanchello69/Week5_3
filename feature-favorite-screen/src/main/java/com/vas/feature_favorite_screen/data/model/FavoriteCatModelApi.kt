package com.vas.feature_favorite_screen.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FavoriteCatModelApi(

    @SerialName("image_id")
    val imageId: String,

)
