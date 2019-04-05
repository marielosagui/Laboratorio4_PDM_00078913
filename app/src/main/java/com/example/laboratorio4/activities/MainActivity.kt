package com.example.laboratorio4.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.AsyncTask;
import com.example.laboratorio4.utils.NetworkUtils

import com.example.laboratorio4.R;
import com.example.laboratorio4.adapters.MovieAdapter
import com.example.laboratorio4.model.Movie
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException

class MainActivity : AppCompatActivity(){

    override  fun onCreate(savedInstanceState :Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun initRecycleView(){
        var viewManager=LinearLayoutManager(this)
        var movieAdapter= MovieAdapter(movieList)
    }

    fun initSearchBar()=add_movie_btn.setOnClickListener{
        if(!movie_name_et.text.isEmpty()){
            FetchMovie().execute(movie_name_et.text.toString())
        }
    }

    private inner class FetchMovie :AsyncTask<String,Void,String>(){
        override fun doInBackground(vararg params: String?): String {
            if(params.isNullOrEmpty())return ""

            val movieName =params[0]
            val movieURL= NetworkUtils().buildSearchUrl(movieName)
            return try {
                NetworkUtils().getResponseFromHttpUrl(movieURL)
            }catch (e:IOException){""
            }
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(movieInfo)

            if(movieJson.getString("Response") =="True"){
               val movie =Gson().fromJson<Movie>(movieInfo)
            }
        }
    }
}
