package com.example.co_opt1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.core.text.isDigitsOnly
import com.example.co_opt1.ui.theme.CoOpt1Theme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.unit.dp
import com.example.co_opt1.ui.theme.RetrofitInstance



class MainActivity : ComponentActivity() {


    // Define a state variable to hold the JSON data
    private var jsonData by mutableStateOf<Products?>(null)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoOpt1Theme {
                MyApp(jsonData)
            }
        }
        // Fetch Data from the API
        fetchDataFromApi()
    }


    ///CHANGE MY DATA TO PRODUCTS
    @Composable
    fun MyApp(products: Products?) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            // Pass the myData parameter to DisplayJsonData
            DisplayJsonData(products)
        }
    }

    @Composable
    fun DisplayJsonData(data: Products?) {
        LazyColumn {
            items(data?.products ?: emptyList()) { product ->
                if (product.title.isNotEmpty()) {
                    val name = product.title
                    val description = product.description
                    val price = product.price

                    Text(
                        text = "$name: $description. $name is priced at $price.",
                        modifier = Modifier.padding(16.dp) // Adjust padding as needed
                    )
                } else {
                    Text(text = "No products were found.")
                }
            }
        }

    }


    private fun fetchDataFromApi() {
        val apiService = RetrofitInstance.retrofit.create(myAPI::class.java)
        val call = apiService.getProducts()

        call.enqueue(object : Callback<Products> {
            override fun onResponse(call: Call<Products>, response: Response<Products>) {
                if (response.isSuccessful) {
                    val myData = response.body()

                    // Update the jsonData state variable with the fetched data
                    jsonData = myData
                } else {
                    // Handle unsuccessful response
                }
            }

            override fun onFailure(call: Call<Products>, t: Throwable) {
                // Handle network error
            }
        })
    }
}
//
//
//
//
//
//
//
//private val BASE_URL = "https://jsonplaceholder.typicode.com/"
//private val TAG: String = "CHECK_RESPONSE"
//private fun getAllProducts() {
//    val api = Retrofit.Builder()
//        .baseUrl(BASE_URL)
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()
//        .create(myAPI::class.java)
//
//    api.getProducts().enqueue(object : Callback<Products>{
//        override fun onResponse(call: Call<Products>, response: Response<Products>) {
//            response.body()?.let{
//                for (product in it){
//                    Log.i(TAG, "onResponse: ${product.id}")
//                }
//            }
//        }
//
//        override fun onFailure(call: Call<Products>, t: Throwable) {
//            Log.i(TAG, "onFailure: ${t.message}")
//        }
//
//    })
//}
//
//
//
//
//@Composable
//fun NumberedTextBoxes(numTextboxes: Int) {
//    Column {
//        for (i in 1..numTextboxes) {
//            Text(text = "Text Box $i")
//        }
//    }
//}
//
//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Surface(
//        modifier = modifier.fillMaxSize(),
//        color = MaterialTheme.colorScheme.background
//    ) {
////        NumberedTextBoxes(numTextboxes = 10) // Adjust the number of text boxes here
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    CoOpt1Theme {
//        Greeting("Android")
//    }
//}