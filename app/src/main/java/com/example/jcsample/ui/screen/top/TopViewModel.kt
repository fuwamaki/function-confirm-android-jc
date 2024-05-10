package com.example.jcsample.ui.screen.top

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jcsample.ui.screen.Screen
import com.example.jcsample.ui.type.TopItemType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TopViewModel @Inject constructor() : ViewModel() {
    private val _showToast = MutableSharedFlow<String>()
    val showToast: SharedFlow<String> = _showToast

    private val _navigateFlow = MutableSharedFlow<Screen>()
    val navigateFlow: SharedFlow<Screen> = _navigateFlow

    fun onItemClick(context: Context, type: TopItemType) = viewModelScope.launch {
        _showToast.emit(type.title(context))
        _navigateFlow.emit(type.screen)
    }
}