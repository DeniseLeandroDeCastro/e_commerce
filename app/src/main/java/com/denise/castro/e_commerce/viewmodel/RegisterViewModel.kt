package com.denise.castro.e_commerce.viewmodel

import androidx.lifecycle.ViewModel
import com.denise.castro.e_commerce.data.User
import com.denise.castro.e_commerce.util.RegisterFieldState
import com.denise.castro.e_commerce.util.RegisterValidation
import com.denise.castro.e_commerce.util.Resource
import com.denise.castro.e_commerce.util.validateEmail
import com.denise.castro.e_commerce.util.validatePassword
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val firebaseAuth: FirebaseAuth
): ViewModel() {

    private val _register = MutableStateFlow<Resource<FirebaseUser>>(Resource.Unspecified())
    val register: Flow<Resource<FirebaseUser>> = _register

    private val _validation = Channel<RegisterFieldState>()
    val validation = _validation.receiveAsFlow()

    fun createAccountWithEmailAndPassword(user: User, password: String) {
        runBlocking {
            _register.emit(Resource.Loading())
        }

        if (checkValidation(user, password)) {
            runBlocking {
                _register.emit(Resource.Loading())
            }

            firebaseAuth.createUserWithEmailAndPassword(user.email, password)
                .addOnSuccessListener { it ->
                    it.user?.let {
                        _register.value = Resource.Success(it)
                    }
                }.addOnFailureListener {
                    _register.value = Resource.Error(it.message.toString())
                }
        } else {
            val registerFieldsState = RegisterFieldState (
                validateEmail(user.email), validatePassword(password)
            )
            runBlocking {
                _validation.send(registerFieldsState)
            }
        }
    }

    private fun checkValidation(user: User, password: String): Boolean {
        val emailValidation = validateEmail(user.email)
        val passwordValidation = validatePassword(password)
        val shouldRegister = emailValidation is RegisterValidation.Success
                && passwordValidation is RegisterValidation.Success

        return shouldRegister
    }
}