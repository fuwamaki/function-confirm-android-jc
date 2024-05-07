package com.example.jcsample.ui.screen.gitRepo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jcsample.model.GitRepo
import com.example.jcsample.repository.GithubRepository
import com.github.michaelbull.result.flatMap
import com.github.michaelbull.result.mapBoth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GitRepoViewModel @Inject constructor(
    private val githubRepository: GithubRepository,
) : ViewModel() {
    private val _isSearching = MutableStateFlow(false)
    val isSearching: StateFlow<Boolean> = _isSearching.asStateFlow()

    private val _searchText = MutableStateFlow("")
    val searchText: StateFlow<String> = _searchText.asStateFlow()

    private var _repositories: MutableStateFlow<List<GitRepo>> = MutableStateFlow(listOf())
    val repositories: StateFlow<List<GitRepo>> get() = _repositories

    fun onSearchTextChange(text: String) {
        _searchText.value = text
    }

    fun onToggleSearch(toggle: Boolean) {
        _isSearching.value = !_isSearching.value
        if (!_isSearching.value) {
            onSearchTextChange("")
        }
    }

    fun onSearch(text: String) = viewModelScope.launch {
        _isSearching.emit(false)
        githubRepository.getRepositories(text).mapBoth(
            success = {
                _repositories.emit(it.items)
                      },
            failure = {}
        )
    }
}