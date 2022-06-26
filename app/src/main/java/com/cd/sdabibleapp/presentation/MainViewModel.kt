package com.cd.sdabibleapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cd.sdabibleapp.domain.models.BookInfo
import com.cd.sdabibleapp.domain.repositories.BibleRepository
import com.cd.sdabibleapp.domain.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

data class MainState(
    val list: List<BookInfo> = emptyList(),
    val loading: Boolean = false,
    val error: String = ""
)

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: BibleRepository
) : ViewModel() {

    private val _state = MutableStateFlow(MainState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getBibleData().collectLatest {
                val (error, data, loading) = it
                when (it) {
                    is Resource.Loading -> {
                        _state.value = state.value.copy(loading = loading)
                    }
                    is Resource.Success -> {
                        _state.value =
                            state.value.copy(list = data ?: emptyList(), loading = loading)
                    }
                    is Resource.Failure -> {
                        _state.value = state.value.copy(error = error ?: "")
                    }
                }
            }
        }
    }

}