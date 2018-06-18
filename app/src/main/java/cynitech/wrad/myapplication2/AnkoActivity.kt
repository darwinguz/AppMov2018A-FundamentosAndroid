package cynitech.wrad.myapplication2

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.github.kittinunf.fuel.httpGet
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg
import org.jetbrains.anko.toast

class AnkoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anko)

        async(UI) {
            llamarPost("1")
            Log.i("async", "Luego de llamar post")
            val data: Deferred<String> = bg {
                //ejecutan tareas en el background
                obtenerSesion()
            }
            //usan las respuestas de las tareas en background
            mostrarToast(data.await())
        }
        Log.i("async", "Termino")
    }

    fun llamarPost(idPost: String) {
        val url = "https://jsonplaceholder.typicode.com/posts/1"
        url.httpGet().responseString() { request, response, result ->
            Log.i("async", "request: $request")
            Log.i("async", "response: $response")
            Log.i("async", "result: $result")
        }
    }

    fun obtenerSesion(): String {
        return "Esta es una sesion"
    }

    fun mostrarToast(mensaje: String) {
        toast(mensaje)
    }


}
