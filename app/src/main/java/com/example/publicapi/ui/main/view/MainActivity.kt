package com.example.publicapi.ui.main.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.publicapi.R
import com.example.publicapi.data.api.ServiceBuilder
import com.example.publicapi.data.model.public
import com.example.publicapi.ui.main.adapter.MainAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadPublics()
    }
    private fun loadPublics() {
        //initiate the service


        //val requestCall  = ServiceBuilder.service.getPublicList()
       val requestCall =ServiceBuilder.requestCall
        requestCall.enqueue(object : Callback<public>{
            override fun onResponse(call: Call<public>, response: Response<public>) {
                //Log.d("Response", "onResponse: ${response.body()}")
                if (response.isSuccessful){
                    val publiclist  = response.body()!!
                    for( public in publiclist.entries){
                      //  Log.d("Response", "publiclist size : ${public.Auth}")
                    }


                    val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)

                     recyclerview.apply {
                          setHasFixedSize(true)
                          layoutManager = GridLayoutManager(this@MainActivity,1)
                          adapter = MainAdapter(response.body()!!)
                      }
                }else{
                    Toast.makeText(this@MainActivity, "Something went wrong ${response.message()}", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<public>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Something went wrong $t", Toast.LENGTH_SHORT).show()
            }
        })

    }
}
