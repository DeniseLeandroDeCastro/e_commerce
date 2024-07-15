package com.denise.castro.e_commerce.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.denise.castro.e_commerce.data.User
import com.denise.castro.e_commerce.databinding.FragmentRegisterBinding
import com.denise.castro.e_commerce.util.RegisterValidation
import com.denise.castro.e_commerce.util.Resource
import com.denise.castro.e_commerce.viewmodel.RegisterViewModel
import com.google.android.material.internal.ViewUtils.hideKeyboard
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class RegisterFragment: Fragment() {

    private lateinit var binding: FragmentRegisterBinding
    private val viewModel: RegisterViewModel by viewModels<RegisterViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterBinding.inflate(inflater)
        return binding.root
    }

    @SuppressLint("RestrictedApi")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            editFirstNameRegister.setOnFocusChangeListener { _, focused ->
                if (!focused) hideKeyboard(editFirstNameRegister)
            }
            editLastNameRegister.setOnFocusChangeListener { _, focused ->
                if (!focused) hideKeyboard(editLastNameRegister)
            }
            editEmailRegister.setOnFocusChangeListener { _, focused ->
                if (!focused) hideKeyboard(editEmailRegister)
            }
            editPasswordRegister.setOnFocusChangeListener { _, focused ->
                if (!focused) hideKeyboard(editPasswordRegister)
            }
        }

        binding.apply {
            buttonRegisterRegister.setOnClickListener {
                val user = User (
                    editFirstNameRegister.text.toString().trim(),
                    editLastNameRegister.text.toString().trim(),
                    editEmailRegister.text.toString().trim(),
                )
                val password = editPasswordRegister.text.toString().trim()
                viewModel.createAccountWithEmailAndPassword(user, password)
            }
        }
        lifecycleScope.launch {
            viewModel.register.collect {
                when(it) {
                    is Resource.Loading -> {
                        binding.lottieAnimation.playAnimation()
                        binding.lottieAnimation.visibility = View.VISIBLE
                        binding.buttonRegisterRegister.visibility = View.INVISIBLE
                    }
                    is Resource.Success -> {
                        Log.d("RegisterFragment", it.data.toString())
                        binding.lottieAnimation.pauseAnimation()
                        binding.lottieAnimation.visibility = View.GONE
                        binding.buttonRegisterRegister.visibility = View.VISIBLE
                    }
                    is Resource.Error -> {
                        Log.e("RegisterFragment", it.message.toString())
                        binding.lottieAnimation.pauseAnimation()
                        binding.lottieAnimation.visibility = View.GONE
                        binding.buttonRegisterRegister.visibility = View.VISIBLE
                    }
                    else -> Unit
                }
            }
        }

        lifecycleScope.launch{
            viewModel.validation.collect { validation ->
                if (validation.email is RegisterValidation.Failed) {
                    withContext(Dispatchers.Main) {
                        binding.editEmailRegister.apply {
                            requestFocus()
                            error = validation.email.message
                        }
                    }
                }

                if (validation.password is RegisterValidation.Failed) {
                    withContext(Dispatchers.Main) {
                        binding.editPasswordRegister.apply {
                            requestFocus()
                            error = validation.password.message
                        }
                    }
                }
            }
        }
    }
}