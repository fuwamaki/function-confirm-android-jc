package com.example.jcsample.ui.screen.webview

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class WebViewModel @Inject constructor() : ViewModel() {

    private var _isLoading: MutableStateFlow<Boolean> = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> get() = _isLoading

    private var _title: MutableStateFlow<String> = MutableStateFlow("")
    val title: StateFlow<String> get() = _title

    fun onPageFinished(title: String?) = viewModelScope.launch {
        _isLoading.emit(false)
        _title.emit(title ?: "")
    }
}