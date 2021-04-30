package com.example.cloudnotes.ui.login

import android.content.Intent
import android.os.Bundle

import android.widget.Toast
import com.example.cloudnotes.R
import com.example.cloudnotes.di.component.ActivityComponent
import com.example.cloudnotes.ui.base.BaseActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity: BaseActivity<LoginViewModel>() {

    companion object {
        private const val TAG = "LoginActivity"
        private const val RC_SIGN_IN = 9001
    }

    @Inject
    lateinit var auth: FirebaseAuth

    @Inject
    lateinit var googleSignInClient: GoogleSignInClient


    override fun provideLayoutId(): Int = R.layout.activity_login



    private fun signIn() {
        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {

                val account = task.getResult(ApiException::class.java)!!
                firebaseAuthWithGoogle(account.idToken!!)
            } catch (e: ApiException) {
                Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show()
            }
        }
    }



    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)

        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {

                    val user = auth.currentUser

                } else {
                    Toast.makeText(this, "Failed", Toast.LENGTH_LONG).show()
                }
            }
    }



    override fun injectDependencies(activityComponent: ActivityComponent) {
        activityComponent.inject(this)

    }

    override fun setupView(savedInstanceState: Bundle?) {
        btn_google_sign_in.setOnClickListener{
            signIn()
        }
    }



    override fun setupObservers() {
        super.setupObservers()
    }
}