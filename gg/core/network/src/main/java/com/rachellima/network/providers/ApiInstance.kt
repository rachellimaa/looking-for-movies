package com.rachellima.network.providers

import android.content.Context
import com.google.gson.GsonBuilder
import com.rachellima.network.api.OmdbApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiInstance {
    private var OMDB_API: OmdbApi? = null
    private const val CONNECTION_TIMEOUT = 60L

    private fun create(context: Context, baseUrl: String) {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .addInterceptor(NetworkInterceptor(context)).build()

        val gson = GsonBuilder().setLenient().create()
        OMDB_API = Retrofit.Builder().baseUrl(baseUrl).client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson)).build().create(OmdbApi::class.java)
    }

    fun getApi(context: Context, baseUrl: String): OmdbApi? {
        create(context, baseUrl)
        return OMDB_API
    }
}
