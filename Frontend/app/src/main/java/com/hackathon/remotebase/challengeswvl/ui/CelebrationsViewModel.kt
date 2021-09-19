package com.hackathon.remotebase.challengeswvl.ui

import androidx.lifecycle.ViewModel
import com.hackathon.remotebase.challengeswvl.repository.MoviesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CelebrationsViewModel @Inject constructor(
    private val repository: MoviesRepository
) : ViewModel() {


}