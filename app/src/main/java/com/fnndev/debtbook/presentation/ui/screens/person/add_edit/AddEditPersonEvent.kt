package com.fnndev.debtbook.presentation.ui.screens.person.add_edit

sealed class AddEditPersonEvent {
    data class OnFullNameChange(val fullName: String) : AddEditPersonEvent()
    data class OnMobileChange(val phoneNumber: String) : AddEditPersonEvent()
    object OnSavePerson : AddEditPersonEvent()
}