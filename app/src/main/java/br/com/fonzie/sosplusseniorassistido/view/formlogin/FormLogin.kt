package br.com.fonzie.sosplusseniorassistido.view.formlogin

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.fonzie.sosplusseniorassistido.databinding.ActivityFormLoginBinding
import br.com.fonzie.sosplusseniorassistido.view.formcadastro.FormCadatro
import br.com.fonzie.sosplusseniorassistido.view.telaprincipal.TelaPrincipal
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth


class FormLogin : AppCompatActivity() {

    private lateinit var binding: ActivityFormLoginBinding
    private val auth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btEntrar.setOnClickListener { view ->
            val email = binding.editEmail.text.toString();
            val senha = binding.editSenha.text.toString();

            if (email.isEmpty() || senha.isEmpty()) {
                val snackbar =
                    Snackbar.make(view, "Preencha todos os campos!", Snackbar.LENGTH_SHORT)
                snackbar.setBackgroundTint(Color.RED)
                snackbar.show()
            } else {
                auth.signInWithEmailAndPassword(email, senha)
                    .addOnCompleteListener { autenticacao ->
                        if (autenticacao.isSuccessful) {
                            navegarTelaPrincipal()
                        }
                    }.addOnFailureListener {
                        val snackbar =
                            Snackbar.make(view, "Erro ao fazer o login do usuário!", Snackbar.LENGTH_SHORT)
                        snackbar.setBackgroundTint(Color.RED)
                        snackbar.show()
                        }
                    }
            }
            binding.txtTelaCadastro.setOnClickListener {
                val intent = Intent(this, FormCadatro::class.java)
                startActivity(intent)
            }
        }
        private fun navegarTelaPrincipal() {
            val intent = Intent(this, TelaPrincipal::class.java)
            startActivity(intent)
            finish()
        }
        override fun onStart() {
            super.onStart()
            val usuarioAtual = FirebaseAuth.getInstance().currentUser

            if (usuarioAtual != null) {
                navegarTelaPrincipal()
            }
        }
    }