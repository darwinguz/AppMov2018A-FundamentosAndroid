package cynitech.wrad.myapplication2

import android.content.DialogInterface
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_dialogo.*

class DialogoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialogo)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()


//        val builder = AlertDialog.Builder(this)
//        builder.setMessage("Hola")
//                .setPositiveButton("Si", DialogInterface.OnClickListener { dialog, which ->
//                    Log.i("dialogo", "Acepto")
//                })
//                .setNegativeButton("No", null)


            val builder2 = AlertDialog.Builder(this)
            val listaItems = resources.getStringArray(R.array.string_array_opciones_dialogo)
            val seleccionUsuario = booleanArrayOf(true, false, false, false)
            builder2.setTitle("Escoja un numero")
                    .setMultiChoiceItems(
                            listaItems,
                            seleccionUsuario,
                            DialogInterface.OnMultiChoiceClickListener { dialogInterface: DialogInterface,
                                                                         i: Int,
                                                                         b ->

                                Log.i("dialogo", "Escogio algo $i")
                            })
//                .setSingleChoiceItems(listaItems/*arrayOf("1", "2", "3")*/, -1) { dialog, which ->
//                    Log.i("dialogo","Selecciono $which")
//                }
//                .setNeutralButton("Cancel") { dialog, which ->
//                    dialog.cancel()
//                }


            builder2.setPositiveButton(
                    "Aceptar",
                    DialogInterface.OnClickListener { dialog, which ->
                        Log.i("dialogo", "Acepto")
                    }
            )
            builder2.setNegativeButton(
                    "Cancelar",
                    null
            )

            val dialogo2 = builder2.create()
            dialogo2.show()


//        val dialogo = builder.create()
//        dialogo.show()

        }

    }

}
