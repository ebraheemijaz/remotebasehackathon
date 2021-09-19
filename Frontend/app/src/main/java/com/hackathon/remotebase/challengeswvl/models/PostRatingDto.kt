package com.hackathon.remotebase.challengeswvl.models

data class PostRatingDto(
    var rating_behaviour: Int,
    var rating_conduct: Int,
    var rating_punctuality: Int,
    var rating_travel: Int,
    var suggestion: String,
)
