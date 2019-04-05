package com.example.laboratorio4.utils

import android.net.Uri
import  java.net.MalformedURLException
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class NetworkUtils {

    val MOVIES_API_URL= "http://www.omdbapi.com/"
    val TOKEN_API="ec26031e"


    fun buildSearchUrl(movieName: String)URL{
        val builtUri:Uri.parse(MOVIES_API_URL)
            .buildUpon()
            .appendQueryParameter("apikey",TOKEN_API)
            .appendQueryParameter("t",movieName)
            .build()

        return try {
            URL(builtUri.toString())
        }catch (e:MalformedURLException){
            URL("") }
    }

    @Throws(IOException::class)
    fun getResponseFromHttpUrl(url:URL):String{
    url urlConnection =url.openConecction() as HttpsURLConnection
    try{
        val `in` = urlC0nnection.inputStream

        val
    }}
}




