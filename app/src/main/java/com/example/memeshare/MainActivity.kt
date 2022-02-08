package com.example.memeshare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//import android.util.Log
import android.view.View
//import android.widget.ImageView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule

// new since Glide v4
@GlideModule
class MyAppGlideModule : AppGlideModule() {
    // leave empty for now
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        memeimage = findViewById(R.id.memeimage)
        loadmeme()
    }
    private fun loadmeme(){
        val queue = Volley.newRequestQueue(this)
        val url = "https://meme-api.herokuapp.com/gimme"

        // Request a string response from the provided URL.
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            Response.Listener { response ->
                val url=response.getString("url")
                //Glide.with(this).load(url).into(memeimage)
                Glide.with(this)
                    .load("https://meme-api.herokuapp.com/gimme")
                    .into(memeimage)
            },
            Response.ErrorListener {

            })

        // Add the request to the RequestQueue.
        queue.add(jsonObjectRequest)
    }
    fun nextmeme(view: View) {}
    fun sharememe(view: View) {}
}