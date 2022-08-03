package com.chyngyzturapov.testapp.ui.first

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chyngyzturapov.testapp.data.model.JsonModel.*
import com.chyngyzturapov.testapp.data.repo.FirstRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FirstViewModel @Inject constructor(private val repository: FirstRepository
) : ViewModel() {
    private val _user = MutableLiveData<User>()
    val user = _user

    fun getUser() {
        viewModelScope.launch {
            repository.getUser().collect {
                _user.value = it
            }
        }
    }
}