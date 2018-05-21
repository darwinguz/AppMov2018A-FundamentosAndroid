package cynitech.wrad.myapplication2

import android.os.Bundle
import android.support.v7.app.AppCompatActivity


class SQliteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sqlite)

        val dbHandler = DbHandlerAplicacion(this)
        dbHandler.insertarUsuario("Adrian")
        dbHandler.leerDatos()
        
    }
}
