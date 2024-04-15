package br.com.fonzie.sosplusseniorassistido.view.formlogin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.fonzie.sosplusseniorassistido.databinding.ActivityFormCadatroBinding
import br.com.fonzie.sosplusseniorassistido.view.formcadastro.FormCadatro


class FormLogin : AppCompatActivity() {

    private lateinit var binding: ActivityFormCadatroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityFormCadatroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btCadastrar.setOnClickListener {

            val intent = Intent(this, FormCadatro::class.java)
            startActivity(intent)
        }
    }
}