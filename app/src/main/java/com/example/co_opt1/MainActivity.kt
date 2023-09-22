package com.example.co_opt1

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.co_opt1.ui.theme.CoOpt1Theme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/* Test Commit */

class MainActivity : ComponentActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoOpt1Theme {
                Greeting("Android")

                getAllProducts()

            }

        }
    }

}
private val BASE_URL = "https://jsonplaceholder.typicode.com/"
private val TAG: String = "CHECK_RESPONSE"
private fun getAllProducts() {
    val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(myAPI::class.java)

    api.getProducts().enqueue(object : Callback<Products>{
        override fun onResponse(call: Call<Products>, response: Response<Products>) {
            response.body()?.let{
                for (product in it){
                    Log.i(TAG, "onResponse: ${product.id}")
                }
            }
        }

        override fun onFailure(call: Call<Products>, t: Throwable) {
            Log.i(TAG, "onFailure: ${t.message}")
        }

    })
}




@Composable
fun NumberedTextBoxes(numTextboxes: Int) {
    Column {
        for (i in 1..numTextboxes) {
            Text(text = "Text Box $i")
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
//        NumberedTextBoxes(numTextboxes = 10) // Adjust the number of text boxes here
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CoOpt1Theme {
        Greeting("Android")
    }
}