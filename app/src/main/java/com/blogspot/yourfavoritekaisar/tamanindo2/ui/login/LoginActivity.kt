package com.blogspot.yourfavoritekaisar.tamanindo2.ui.login

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import com.blogspot.yourfavoritekaisar.tamanindo2.R
import com.blogspot.yourfavoritekaisar.tamanindo2.ui.main.MainActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private val firebaseAuth = FirebaseAuth.getInstance()
    private val firebaseAuthListener = FirebaseAuth.AuthStateListener {
        val user = firebaseAuth.currentUser?.uid
        if (user != null) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setTextChangedListener(edt_email, tillEmail)
        setTextChangedListener(edt_password, tillPassword)
        progress_bar.setOnTouchListener { _, _ -> true }

        btn_login.setOnClickListener {
            onLogin()
        }
    }

    private fun onLogin() {
        var proceed = true
        if (edt_email.text.isNullOrEmpty()) {
            tillEmail.error = "Required Email"
            tillEmail.isErrorEnabled = true
            proceed = false
        }

        if (edt_password.text.isNullOrEmpty()) {
            tillPassword.error = "Required Password"
            tillPassword.isErrorEnabled = true
            proceed = false
        }

        if (proceed) {
            progress_bar.visibility = View.VISIBLE
            firebaseAuth.signInWithEmailAndPassword(
                edt_email.text.toString(),
                edt_password.text.toString()
            ).addOnCompleteListener { task ->
                if (!task.isSuccessful) {
                    progress_bar.visibility = View.GONE
                    Toast.makeText(
                        this, "Login Error: ${task.exception?.localizedMessage}"
                        , Toast.LENGTH_SHORT
                    ).show()
                }
            }.addOnFailureListener {
                progress_bar.visibility = View.GONE
                it.printStackTrace()
            }
        }
    }

    private fun setTextChangedListener(edt: TextInputEditText?, till: TextInputLayout?) {
        edt?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                till?.isErrorEnabled = false
            }
        })
    }

    override fun onStart() {
        super.onStart()
        firebaseAuth.addAuthStateListener(firebaseAuthListener)
    }

    override fun onStop() {
        super.onStop()
        firebaseAuth.removeAuthStateListener(firebaseAuthListener)
    }
}