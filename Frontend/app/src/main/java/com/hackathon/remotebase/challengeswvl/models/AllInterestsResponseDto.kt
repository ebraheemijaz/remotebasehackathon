package com.hackathon.remotebase.challengeswvl.models

import com.google.gson.annotations.SerializedName

data class AllInterestsResponseDto(

    val page: Int,
    @SerializedName("InterstCategory")
    val InterstCategory: List<InterestsDto>

)

data class InterestsDto(
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("name")
    val name: String,
    @SerializedName("image")
    val image: String
)