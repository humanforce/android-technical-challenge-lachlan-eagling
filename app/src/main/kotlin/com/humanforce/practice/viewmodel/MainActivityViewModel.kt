package com.humanforce.practice.viewmodel

import androidx.compose.runtime.Immutable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.humanforce.practice.io.Services
import com.humanforce.practice.models.ShiftDetail
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@Immutable
data class MainActivityState(
    val shiftList: List<ShiftDetail> = emptyList()
)

class MainActivityViewModel : ViewModel() {

    private val _state = MutableStateFlow(MainActivityState())
    val state = _state.asStateFlow()

    private fun getShiftList() {
        throw NotImplementedError("Not implemented yet")
    }
}