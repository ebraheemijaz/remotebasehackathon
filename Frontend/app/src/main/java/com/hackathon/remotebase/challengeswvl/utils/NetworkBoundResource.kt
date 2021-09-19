package com.hackathon.remotebase.challengeswvl.utils

import kotlinx.coroutines.flow.flow
import retrofit2.Response

inline fun <T> networkBoundResource(
    crossinline fetch: suspend () -> Response<T>
) = flow {

    emit(Resource.loading(null))

    try {
        emit(Resource.success(fetch().body()))
    } catch (throwable: Throwable) {
        emit(Resource.error(throwable?.localizedMessage.toString(), null))
    }
}