package com.example.apidatabase.viewmodel

import android.net.http.HttpException
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apidatabase.Repository.KontakRepository
import com.example.apidatabase.model.Kontak
import kotlinx.coroutines.launch
import java.io.IOException

sealed class KontakUIState {
    data class Success(val kontak: List<Kontak>) : KontakUIState()

    object Error : KontakUIState()

    object Loading : KontakUIState()
}

class HomeViewModel (private val kontakRepository: KontakRepository) : ViewModel(){

    var kontakUIState: KontakUIState by mutableStateOf(KontakUIState.Loading)
        private set
    init {
        getKontak()
    }

    fun getKontak(){
        viewModelScope.launch {
            kontakUIState = KontakUIState.Loading
            kontakUIState = try {
                KontakUIState.Success(kontakRepository.getKontak())
            } catch (e: IOException){
                KontakUIState.Error
            } catch (e: HttpException){
                KontakUIState.Error
            }
        }
    }
}