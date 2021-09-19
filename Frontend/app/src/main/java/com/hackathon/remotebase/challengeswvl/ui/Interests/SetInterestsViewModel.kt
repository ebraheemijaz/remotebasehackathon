package com.hackathon.remotebase.challengeswvl.ui.Interests

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hackathon.remotebase.challengeswvl.models.AllInterestsResponseDto
import com.hackathon.remotebase.challengeswvl.repository.MoviesRepository
import com.hackathon.remotebase.challengeswvl.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class SetInterestsViewModel @Inject constructor(
    private val repository: MoviesRepository
) : ViewModel() {

    private val _allInterests = MutableLiveData<Resource<AllInterestsResponseDto>>()
    val allInterestsResponseDto: LiveData<Resource<AllInterestsResponseDto>>
        get() = _allInterests

    init {
        getAllInterests()
    }

    private fun getAllInterests() = viewModelScope.launch {

        _allInterests.postValue(Resource.loading(null))

        _allInterests.postValue(handleResponse(repository.getAllInterest()))

    }

    private fun handleResponse(response: Response<AllInterestsResponseDto>): Resource<AllInterestsResponseDto>? {
        if (response.isSuccessful) {

            response.body()?.let { allInterestsResponseDto ->
                return Resource.success(allInterestsResponseDto)

            }
        }

        Log.d("response", "error: ${response.code()}")
        return Resource.error(response.message(), null)

    }

    fun postUserInterests() {
        //post an array of selected interests

    }
}