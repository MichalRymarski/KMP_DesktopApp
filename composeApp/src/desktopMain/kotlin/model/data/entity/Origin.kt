package model.data.entity

import kotlinx.serialization.Serializable

@Serializable
data class Origin(
    val name: String,
    val url: String
)

