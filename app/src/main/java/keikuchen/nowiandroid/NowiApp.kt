package keikuchen.nowiandroid

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import keikuchen.nowiandroid.ui.theme.NowiAndroidTheme

@Composable
fun NowiApp() {
    NowiAndroidTheme {
        Greeting()
    }
}

@Composable
fun Greeting(name: String = "Android") {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Text(text = "Hello $name!")
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NowiAndroidTheme {
        Greeting("Android")
    }
}
