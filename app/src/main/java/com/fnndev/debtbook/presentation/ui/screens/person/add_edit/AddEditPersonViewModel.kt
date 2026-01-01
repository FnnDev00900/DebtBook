package com.fnndev.debtbook.presentation.ui.screens.person.add_edit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fnndev.debtbook.domain.model.Person
import com.fnndev.debtbook.domain.repository.PersonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddEditPersonViewModel @Inject constructor(
    private val repository: PersonRepository
) : ViewModel() {
    private val _state = MutableStateFlow(AddEditPersonState())
    val state: StateFlow<AddEditPersonState> = _state.asStateFlow()

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow: SharedFlow<UiEvent> = _eventFlow.asSharedFlow()

    fun onEvent(event: AddEditPersonEvent) {
        when (event) {
            is AddEditPersonEvent.OnFullNameChange -> {
                _state.update {
                    it.copy(personFullName = event.fullName)
                }
            }

            is AddEditPersonEvent.OnMobileChange -> {
                _state.update {
                    it.copy(personMobile = event.phoneNumber)
                }
            }

            is AddEditPersonEvent.OnSavePerson -> {
                viewModelScope.launch {
                    try {
                        repository.insertPerson(
                            Person(
                                fullName = state.value.personFullName,
                                mobile = state.value.personMobile,
                                description = null // TODO: Add description field if needed
                            )
                        )
                        _eventFlow.emit(UiEvent.SavePerson)
                    } catch (e: Exception) {
                        _eventFlow.emit(UiEvent.ShowSnackBar(e.message ?: "Couldn't save person"))
                    }
                }
            }
        }
    }

    sealed class UiEvent {
        data class ShowSnackBar(val message: String) : UiEvent()
        data object SavePerson : UiEvent()
    }
}