package com.example.renata.apitest.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.renata.apitest.JsonPlacerHolderApi
import com.example.renata.apitest.MainActivity
import com.example.renata.apitest.R
import com.example.renata.apitest.api.HttpHelper
import com.example.renata.apitest.model.Car
import com.example.renata.apitest.model.Entrance
import com.example.renata.apitest.model.Paid
import com.example.renata.apitest.model.Plate
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_car_status.*
import kotlinx.android.synthetic.main.toolbar.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CarStatusActivity : AppCompatActivity() {
    companion object{
        var car : Car?= null
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car_status)

        txtNumberLincence1.text = car!!.plate
        txtTypeStatus.text = if (car!!.left == false) "Estacionado" else "Liberado"
        txtTime.text = car!!.time.toString()
        txtStatusPayment.text = if (car!!.paid == true) "Pago" else "--"

        img_CarStatus.setOnClickListener {
            startActivity(Intent(this@CarStatusActivity, HistoryActivity::class.java))
        }
        btnMenu.setOnClickListener {
            //startActivity(Intent(this@CarStatusActivity, NavMenu::class.java))
        }
    }
}

/**
 * val retrofit = Retrofit.Builder()
.baseUrl("https://parking-lot-to-pfz.herokuapp.com/parking/")
.addConverterFactory(GsonConverterFactory.create())
.build()
val jsonPlacerHolderApi = retrofit.create(JsonPlacerHolderApi::class.java)
//val call: Call<Entrance> = jsonPlacerHolderApi.postEntrance("AAA-4444")
val call: Call<Entrance> = jsonPlacerHolderApi.postEntrance(Plate("AAA-4444"))
call!!.enqueue(object : Callback<Entrance>{
override fun onResponse(call: Call<Entrance>, response: Response<Entrance>) {
if (response.isSuccessful) {
textViewRenis.text = "Code "+response.code().toString()+
response.body()!!.entered_at+
response.body()!!.reservation+
response.body()!!.plate
Log.i("info", "renis " + response.code())
}
}

override fun onFailure(call: Call<Entrance>, t: Throwable) {
showError()
}

})
}
private fun showError() {
Toast.makeText(this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show()
}
 */


/// tanto para a funcao postExit como postPaid funciona essas formulas

/**
 * val retrofit = Retrofit.Builder()
.baseUrl("https://parking-lot-to-pfz.herokuapp.com/parking/")
.addConverterFactory(GsonConverterFactory.create())
.build()
val jsonPlacerHolderApi = retrofit.create(JsonPlacerHolderApi::class.java)
//val call: Call<Entrance> = jsonPlacerHolderApi.postEntrance("AAA-4444")
val call: Call<Paid> = jsonPlacerHolderApi.postExit("AAA-4444")
call!!.enqueue(object : Callback<Paid>{
override fun onResponse(call: Call<Paid>, response: Response<Paid>) {
if (response.isSuccessful) {
Log.i("info", "renis " + response.code())
textViewRenis.text = "Code "+response.code().toString()//+
//response.body()!!.number
Log.i("info", "renis " + response.code())
}
}

override fun onFailure(call: Call<Paid>, t: Throwable) {
Log.i("info", "renis " +t.message)
showError()
}

})
}
private fun showError() {
Toast.makeText(this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show()
}
 */

// postEntrace nao funciona
/*val retrofit = Retrofit.Builder()
            .baseUrl("https://parking-lot-to-pfz.herokuapp.com/parking")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val jsonPlacerHolderApi = retrofit.create(JsonPlacerHolderApi::class.java)
        //val call: Call<Entrance> = jsonPlacerHolderApi.postEntrance("AAA-4444")
        val call: Call<Entrance> = jsonPlacerHolderApi.postEntrance("AAA-4444")
        call!!.enqueue(object : Callback<Entrance>{
            override fun onResponse(call: Call<Entrance>, response: Response<Entrance>) {
                if (response.isSuccessful) {
                    Log.i("info", "renis " + response.code())
                    textViewRenis.text = "Code "+response.code().toString()//+
                            //response.body()!!.number
                    Log.i("info", "renis " + response.code())
                }
            }

            override fun onFailure(call: Call<Entrance>, t: Throwable) {
                Log.i("info", "renis " +t.message)
                showError()
            }

        })*/

/**
 * val plate = Plate("AAA-4444")
val gson = Gson()
val plateGson = gson.toJson(plate)
Log.i("info", "renis " + plateGson)
/*CoroutineScope(Dispatchers.IO).launch {
val http = HttpHelper().post(plateGson)
Log.i("info", "renis " + http[0])
}*/

val http = HttpHelper().post("AAA-4444")
Log.i("info", "renis 2 " + http.toString())

}
private fun showError() {
Toast.makeText(this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show()
}
 */