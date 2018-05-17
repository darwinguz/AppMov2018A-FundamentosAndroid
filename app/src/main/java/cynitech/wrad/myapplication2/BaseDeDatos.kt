package cynitech.wrad.myapplication2

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

/**
 * Created by USRGAM on 16/05/2018.
 */
class BaseDeDatos {
    companion object {
        val BDD_NOMBRE = "aplicacion"
        val BDD_TABLA_USUARIO_NOMBRE = "usuario"
        val BDD_TABLA_USUARIO_CAMPO_ID = "id"
        val BDD_TABLA_USUARIO_CAMPO_NOMBRE = "nombre"
    }
}

class DatabaseSQLite {
    companion object {
        val DB_NAME = "user"
        val USR_TABLE_NAME = "usuario"
        val COL_ID = "id"
        val COL_NOMBRE = "nombre"
        val COL_EDAD = "edad"
        val COL_CASADO = "casado"
    }
}

class DbHandlerAplicacion(context: Context) : SQLiteOpenHelper(context, BaseDeDatos.BDD_NOMBRE, null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {

        val createTableSQL = "CREATE TABLE ${BaseDeDatos.BDD_TABLA_USUARIO_NOMBRE} (${BaseDeDatos.BDD_TABLA_USUARIO_CAMPO_ID} INTEGER PRIMARY KEY AUTOINCREMENT, ${BaseDeDatos.BDD_TABLA_USUARIO_CAMPO_NOMBRE} VARCHAR(50))"

        db?.execSQL(createTableSQL)
    }


    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun insertarUsuario(nombre: String) {
        val dbWriteable = writableDatabase
        var cv = ContentValues()
        cv.put(DatabaseSQLite.COL_NOMBRE, nombre)
        val resultado = dbWriteable.insert(DatabaseSQLite.USR_TABLE_NAME, null, cv)
        Log.i("database", "Si es -1 hubo error, sino exito: Respuesta:$resultado")
        dbWriteable.close()
    }

    fun leerDatos() {
        val dbReadable = readableDatabase
        val query = "SELECT * FROM ${DatabaseSQLite.USR_TABLE_NAME}"
        val resultado = dbReadable.rawQuery(query, null)
        if (resultado.moveToFirst()) {
            do {
                val idActual = resultado.getString(0).toInt()
                val nombreActual = resultado.getString(1)
                Log.i("database", "El nombre es $nombreActual con id $idActual")
            } while (resultado.moveToNext())
        }
        resultado.close()
        dbReadable.close()
    }

}