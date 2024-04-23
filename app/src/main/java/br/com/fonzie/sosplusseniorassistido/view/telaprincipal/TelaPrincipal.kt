package br.com.fonzie.sosplusseniorassistido.view.telaprincipal

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import br.com.fonzie.sosplusseniorassistido.databinding.ActivityTelaPrincipalBinding
import br.com.fonzie.sosplusseniorassistido.view.formlogin.FormLogin
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class TelaPrincipal : AppCompatActivity() {

    private lateinit var binding: ActivityTelaPrincipalBinding
    private val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btDeslogar.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val voltarTelaLogin = Intent(this,FormLogin::class.java)
            startActivity(voltarTelaLogin)
            finish()
        }

        binding.btGravarDadosDB.setOnClickListener {

            val usuariosMap = hashMapOf(
                "nome" to "Ana",
                "sobrenome" to "Silva",
                "telefone" to 51987654321,
//                "email" to "arturbazzanellamidia@gmail.com",
//                "cpf" to 90329970097
            )

            db.collection("Usuários").document("Ana")
                .set(usuariosMap).addOnCompleteListener {
                    Log.d("db", "Sucesso ao salvar os dados do usuário!")
                }.addOnFailureListener {

                }
        }
        binding.btLerDadosBD.setOnClickListener {
            db.collection("Usuários").document("Ana")
                .addSnapshotListener { documento, error ->
                    if (documento != null) {
                        var telefone = documento.getLong("telefone")
                        binding.txtResultadoNome.text = documento.getString("nome")
                        binding.txtResultadoSobrenome.text = documento.getString("sobrenome")
                        binding.txtResultadoTelefone.text = telefone.toString()
                    }
                }
        }

//        binding.btAtualizarDadosDB.setOnClickListener {
//
//            db.collection("Usuários").document("Ana")
//                .update("sobrenome", "da Silva").addOnCompleteListener {
//                    Log.d("db_update", "Sucesso ao atualizar os dados do usuário!")
//                }
//        }

    }
}
