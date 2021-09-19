package com.hackathon.remotebase.challengeswvl.api

import com.hackathon.remotebase.challengeswvl.models.AllInterestsResponseDto
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("getallinterest")
    suspend fun getAllInterests(): Response<AllInterestsResponseDto>

}