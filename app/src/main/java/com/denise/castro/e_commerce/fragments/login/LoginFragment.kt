package com.denise.castro.e_commerce.fragments.login

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.denise.castro.e_commerce.R
import com.denise.castro.e_commerce.activities.ShoppingActivity
import com.denise.castro.e_commerce.databinding.FragmentLoginBinding
import com.denise.castro.e_commerce.dialog.setupBottomSheetDialog
import com.denise.castro.e_commerce.util.Resource
import com.denise.castro.e_commerce.viewmodel.LoginViewModel
import com.google.android.material.internal.ViewUtils.hideKeyboard
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class LoginFragment: Fragment(R.layout.fragment_login) {

    private lateinit var binding: FragmentLoginBinding
    private val viewModel by viewModels<LoginViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater)
        return binding.root
    }

    @SuppressLint("RestrictedApi", "ResourceAsColor")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvDontHaveAccountLogin.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

        binding.apply {
            editEmailLogin.setOnFocusChangeListener { _, focused ->
                if (!focused) hideKeyboard(editEmailLogin)
            }
            editPasswordLogin.setOnFocusChangeListener { _, focused ->
                if (!focused) hideKeyboard(editPasswordLogin)
            }
        }

        binding.apply {
            buttonLoginLogin.setOnClickListener {
                val email = editEmailLogin.text.toString().trim()
                val password = editPasswordLogin.text.toString()
                viewModel.login(email, password)
            }
        }

        binding.tvForgotPasswordLogin.setOnClickListener {
            setupBottomSheetDialog {email ->
                viewModel.resetPassword(email)
            }
        }

        lifecycleScope.launch {
            viewModel.resetPassword.collect {
                when(it) {
                    is Resource.Loading -> {}

                    is Resource.Success -> {
                        Snackbar.make(
                            requireView(),
                            "O link para redefinção de senha foi enviado para o email informado.",
                            Snackbar.LENGTH_LONG).show()
                    }

                    is Resource.Error -> {
                        Snackbar.make(requireView(), "Error: ${it.message}", Snackbar.LENGTH_LONG).show()
                    }
                    else -> Unit
                }
            }
        }

        lifecycleScope.launch {
            viewModel.login.collect {
                when(it) {
                    is Resource.Loading -> {
                        binding.lottieAnimation.playAnimation()
                        binding.lottieAnimation.visibility = View.VISIBLE
                        binding.buttonLoginLogin.visibility = View.INVISIBLE
                    }

                    is Resource.Success -> {
                        Intent(requireActivity(), ShoppingActivity::class.java).also { intent ->
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                            startActivity(intent)

                        }
                    }

                    is Resource.Error -> {
                        Snackbar.make(requireView(), "Usuário / Senha incorretos!", Snackbar.LENGTH_LONG).show()
                    }
                    else -> Unit
                }
            }
        }
    }
}