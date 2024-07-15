package com.denise.castro.e_commerce.util

import android.util.Patterns

fun validateEmail(email: String): RegisterValidation {
    if (email.isEmpty())
        return RegisterValidation.Failed("Email não pode ser vazio")

    if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        return RegisterValidation.Failed("Formato do email incorreto")

    return RegisterValidation.Success
}

fun validatePassword(password: String): RegisterValidation {
    if (password.isEmpty())
        return RegisterValidation.Failed("A senha não pode ser vazia")

    if (password.length < 8)
        return RegisterValidation.Failed("A senha deve conter pelo menos 8 caracteres")

    return RegisterValidation.Success
}