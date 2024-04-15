package com.humanforce.practice.io

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object NetworkModule {

    private val baseUrl: String = "https://humanforce-android-practice.p.rapidapi.com/"

    private val tokenTokenInterceptor: Interceptor by lazy { ApiKeyInterceptor() }

    val moshi: Moshi by lazy {
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    val okHttpClient: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor(tokenTokenInterceptor)
            .addNetworkInterceptor(HttpLoggingInterceptor().apply {
                setLevel(HttpLoggingInterceptor.Level.BODY )
            })
            // .addNetworkInterceptor(HttpLoggingInterceptor().apply {
            //     setLevel(if (com.humanforce.BuildConfig.DEBUG_MODE) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE)
            // })
            // .callTimeout(1, TimeUnit.MINUTES)
            // .connectTimeout(1, TimeUnit.MINUTES)
            // .writeTimeout(1, TimeUnit.MINUTES)
            // .readTimeout(1, TimeUnit.MINUTES)
            .build()
    }

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            // .addCallAdapterFactory(HfCallAdapterFactory.create(app, retrySubject))
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .build()
    }

}


open class ApiKeyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder().apply {
            header("X-RapidAPI-Key", "c9c04b059cmsh5ba2b12d83e1126p1c0d63jsn9cd037912c60")
            header("X-RapidAPI-Host", "humanforce-android-practice.p.rapidapi.com")
        }.build()
        return chain.proceed(request)
    }
}
