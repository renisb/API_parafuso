package com.example.renata.apitest

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.example.renata.apitest.adapter.VPagerAdapter
import com.example.renata.apitest.fragment.ParkingFragment
import com.example.renata.apitest.fragment.PaymentFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*


class MainActivity : AppCompatActivity() {

    val adapter = VPagerAdapter(supportFragmentManager)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpTabs()
        setSupportActionBar(findViewById(R.id.toolbar))
        btnMenu.setOnClickListener {
            drawer_layout.openDrawer(GravityCompat.START)
            //startActivity(Intent(this@MainActivity, NavMenu::class.java))
        }
        navview.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_entrance -> {
                    viewPager.adapter = adapter
                    tabs.setupWithViewPager(viewPager)
                    Log.i("ERROR", "Chegamos renis1")
                    drawer_layout.closeDrawer(GravityCompat.START)
                    //fragmentManager.beginTransaction().replace(R.id., new Parking_Fragment()).commit();
                }
                R.id.menu_exit -> {
                    viewPager.adapter = adapter
                    tabs.setupWithViewPager(viewPager)
                    Log.i("ERROR", "Chegamos renis2")
                    drawer_layout.closeDrawer(GravityCompat.START)
                }
            }
            false
        }
    }
    private fun setUpTabs(){
        adapter.addFragment(ParkingFragment(),"Entrada")
        adapter.addFragment(PaymentFragment(),"Saída")
        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)
        ///tabs.getTabAt(0)!!.setIcon(R.drawable.)
    }
}

/**
 * textViewResult = findViewById(R.id.text_view_result)
text_view_result.text = "Renata"

val retrofit = Retrofit.Builder()
.baseUrl("https://parking-lot-to-pfz.herokuapp.com/parking/")
.addConverterFactory(GsonConverterFactory.create())
.build()
val jsonPlacerHolderApi = retrofit.create(JsonPlacerHolderApi::class.java)
val call: Call<List<Car>> = jsonPlacerHolderApi.getPosts()
Toast.makeText(this, "Aqui ",Toast.LENGTH_SHORT).show()
text_view_result.text = "Renata2"
call!!.enqueue(object : Callback<List<Car>> {
override fun onResponse(call: Call<List<Car>>, response: Response<List<Car>>) {
text_view_result.text = "Renata3"
if (response.isSuccessful) {
text_view_result.text = "Renata4"
text_view_result.text = "Code: " + response.code()
Log.i("info", "renis " + response.code())
//return
}
cars = response.body()!!
for (post in cars!!) {
var content = "" +post.plate
for (h in list) {
h.payment = if (post.paid == true) "Pago" else "--"
h.time1 = post.time
}
/*content += """
ID:${post.getId().toString()}
Title:${post.getTitle()}
""".trimIndent()*/
text_view_result.text = "Renata5" + cars.toString()
Log.i("info", "renis 1 " +  (cars as ArrayList<Car>).toArray().toString())
Log.i("info", "renis 2 " +  list.toString())
for (h in list) {
Log.i("info", "renis 2 " +  h.payment+" "+h.time1)
text_view_result.text = "Renata6"  +  h.payment+" "+h.time1
}

}
}

override fun onFailure(call: Call<List<Car>>, t: Throwable) {
text_view_result.text = t.message
Log.i("info", "renis " + t.message)
}
})
rcCar.setLayoutManager(LinearLayoutManager(this))
rcCar.setHasFixedSize(true)
adapterHistory = AdapterHitory(list,this)
 */