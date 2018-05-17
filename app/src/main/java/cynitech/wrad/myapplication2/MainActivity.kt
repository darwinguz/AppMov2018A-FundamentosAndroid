package cynitech.wrad.myapplication2

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val permisosDeCamara = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA
        )

        val permisosDeSendSms = ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS
        )

        val noTienePermisosDeCamara = permisosDeCamara != PackageManager.PERMISSION_GRANTED

        val noTienePermisosDeSendSms = permisosDeSendSms != PackageManager.PERMISSION_GRANTED

        if (noTienePermisosDeCamara && noTienePermisosDeSendSms) {

            Log.i("tag", "Entrando a pedir permiso")

            ActivityCompat.requestPermissions(this,
                    arrayOf(Manifest.permission.CAMERA,
                            Manifest.permission.SEND_SMS),
                    RESULTADO_PERMISO_CAMARA)

        } else {
            Log.i("tag", "Ya tiene este permiso")
        }


//        fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).show()
//        }

        // nuestro codigo

        btn_navegar_activida_dos
                .setOnClickListener { view: View ->
                    irAActividadDos()
                }


        spinner_button
                .setOnClickListener { view: View ->
                    irAActividadSpinner()
                }

        botton_crear_usuario
                .setOnClickListener { view: View ->
                    irAActividadCrearUsuario()
                }


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun irAActividadDos() {
        val intent = Intent(this, ActividadDosActivity::class.java)
        intent.putExtra("nombre", "Adrian Eguez")
        startActivity(intent)
    }


    fun irAActividadSpinner() {
        val intent = Intent(this, SpinnerActivity::class.java)
        startActivity(intent)
    }

    fun irAActividadCrearUsuario() {
        val intent = Intent(this, CrearUsuarioActivity::class.java)
        startActivity(intent)
    }


    override fun onRequestPermissionsResult(
            requestCode: Int,
            permissions: Array<String>,
            grantResults: IntArray) {
        when (requestCode) {
            RESULTADO_PERMISO_CAMARA -> {
                Log.i("etiqueta", "Recibimos resultado")
            }
        }
    }


    companion object {
        val RESULTADO_PERMISO_CAMARA = 1;
    }
}













