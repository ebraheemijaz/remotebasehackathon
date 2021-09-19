package com.hackathon.remotebase.challengeswvl.repository

import com.hackathon.remotebase.challengeswvl.api.ApiService
import javax.inject.Inject

class MoviesRepository @Inject constructor(
    val apiService: ApiService,
) {

    suspend fun getAllInterest() = apiService.getAllInterests()

}