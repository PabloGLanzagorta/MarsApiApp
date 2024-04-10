package com.example.dogapiapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dogapiapp.model.MarsPhoto
import com.example.dogapiapp.network.DogApi
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface MarsUiState{
    data class Success(val photos: List<MarsPhoto>) : MarsUiState
    object Error: MarsUiState
    object Loading: MarsUiState
}
class DogViewModel: ViewModel(){
    var marsUiState:MarsUiState  by mutableStateOf(MarsUiState.Loading)
        private set

    init{
        getDogPhotos()
    }

    private  fun getDogPhotos(){
        viewModelScope.launch {
            marsUiState = try {
                val listResult = DogApi.retrofitService.getPhotos()
                MarsUiState.Success(listResult)
            } catch (e: IOException){
                MarsUiState.Error
            }

        }
    }

}