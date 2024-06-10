package model.data.entity

import kotlinx.serialization.Serializable

@Serializable
data class Location(
    val name: String,
    val url: String
)
