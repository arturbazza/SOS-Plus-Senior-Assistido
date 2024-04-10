package br.com.fonzie.sosplusseniorassistido.view.formcadastro

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.fonzie.sosplusseniorassistido.R
import br.com.fonzie.sosplusseniorassistido.databinding.ActivityFormCadatroBinding
import com.google.android.material.snackbar.Snackbar

class FormCadatro : AppCompatActivity() {

    private lateinit var binding: ActivityFormCadatroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormCadatroBinding.inflate((layoutInflater))
        setContentView(binding.root)

        binding.btCadastrar.setOnClickListener{ view ->
            val email = binding.editEmail.text.toString()
            val senha = binding.editSenha.text.toString()

            if (email.isEmpty() || senha.isEmpty()) {
                val snackbar = Snackbar.make(view,"Preencha todos os campos!", Snackbar.LENGTH_SHORT)
                snackbar.setBackgroundTint(Color.RED)
                snackbar.show()
            } else {

            }
        }
    }
}