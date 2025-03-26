package com.example.clone_funalito

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.clone_funalito.ui.theme.Clone_funalitoTheme
import com.example.clone_funalito.vista_modelos.FulanitoViewModel

class MainActivity : ComponentActivity() {
    private val modelo_app = FulanitoViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Clone_funalitoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   PantallaDePublicaciones(vm_funalito = modelo_app)

                }
            }
        }
    }
}

@Composable
fun PantallaDePublicaciones(vm_funalito: FulanitoViewModel){
  val publicaciones_descargadas  by vm_funalito.publicaciones.observeAsState(emptyList())
LaunchedEffect(Unit) {
    vm_funalito.descargar_todas_las_publicaciones()
}
    Column {
        if(publicaciones_descargadas.isEmpty()) {
            Text("Aqui deberia colocar una barra de cargando")
    }
        else {
            LazyColumn {
                items(publicaciones_descargadas){ publicacion ->
                    Text("Titulo: ${publicacion.title}")
                    Text("${publicacion.body}")
                    HorizontalDivider()

                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Clone_funalitoTheme {

    }
}