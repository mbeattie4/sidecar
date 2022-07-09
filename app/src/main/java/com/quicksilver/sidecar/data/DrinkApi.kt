package com.quicksilver.sidecar.data

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object DrinkApi {

    private const val BaseUrl: String = "https://www.thecocktaildb.com/api/json/v1/1/"

    private val okHttpClient: OkHttpClient by lazy { OkHttpClient.Builder().build() }

    private val moshi: Moshi by lazy {
        Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
    }

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BaseUrl)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    val drinkApiService: DrinkService by lazy { retrofit.create(DrinkService::class.java) }
}
