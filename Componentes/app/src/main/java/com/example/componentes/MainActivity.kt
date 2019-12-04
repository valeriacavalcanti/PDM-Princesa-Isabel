package com.example.componentes

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    private lateinit var btPopup: Button
    private lateinit var lista: ListView
    private lateinit var dados: ArrayList<String>
    private lateinit var etCampus: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.btPopup = findViewById(R.id.btPopup)
        this.btPopup.setOnClickListener({ janelaPopup(it) })

        this.lista = findViewById(R.id.lista)
        this.lista.setOnItemClickListener(OnClickLista())
        this.lista.setOnItemLongClickListener(OnLongClickLista())

        this.dados = arrayListOf<String>("Joao Pessoa", "Princesa Isabel", "Campina Grande",
                                        "Sousa", "Cajazeiras", "Cabedelo")

        var layout = android.R.layout.simple_list_item_1

        this.lista.adapter = ArrayAdapter<String>(this, layout, this.dados)
    }

    // listener para o botão btPopup
    fun janelaPopup(view: View){
        val dialog = AlertDialog.Builder(this)

        dialog.setTitle("IFPB")
        dialog.setIcon(R.mipmap.ic_launcher_round)
        dialog.setMessage("Informe o nome do Campus")

        // EditText da Janela Popup (AlertDialog)
        this.etCampus = EditText(this)
        dialog.setView(this.etCampus)

        dialog.setPositiveButton("Salvar", OnClickBotaoJanela())
        dialog.setNegativeButton("Canelar", null)
        dialog.create().show()
    }

    fun atualizaListView(){
        (this.lista.adapter as ArrayAdapter<String>).notifyDataSetChanged()
    }

    // Listener para a Janela de Dialógo (AlertDialog)
    inner class OnClickBotaoJanela: DialogInterface.OnClickListener{
        override fun onClick(dialog: DialogInterface?, which: Int) {
            var msg = this@MainActivity.etCampus.text.toString()
            this@MainActivity.dados.add(msg)
            this@MainActivity.atualizaListView()

            Toast.makeText(this@MainActivity, "Salvo com sucesso!", Toast.LENGTH_SHORT).show()
        }
    }

    inner class OnClickLista: AdapterView.OnItemClickListener{
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            var campus = this@MainActivity.dados.get(position)

            Toast.makeText(this@MainActivity, campus, Toast.LENGTH_SHORT).show()
        }

    }

    inner class OnLongClickLista : AdapterView.OnItemLongClickListener{
        override fun onItemLongClick(
            parent: AdapterView<*>?,
            view: View?,
            position: Int,
            id: Long
        ): Boolean {
            this@MainActivity.dados.removeAt(position)
            this@MainActivity.atualizaListView()
            Log.i("APP_COMPONENTE", this@MainActivity.dados.toString())
            return true
        }

    }
}
