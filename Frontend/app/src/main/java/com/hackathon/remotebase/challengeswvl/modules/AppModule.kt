package com.hackathon.remotebase.challengeswvl.modules

import android.util.Log
import com.hackathon.remotebase.challengeswvl.api.ApiService
import com.hackathon.remotebase.challengeswvl.utils.AppConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideInterceptor() =
        Interceptor { chain ->

            val url = chain.request()
                .url
                .newBuilder()
//                .addQueryParameter("api_key", API_KEY)
                .build()

            val request = chain.request()
                .newBuilder()
                .url(url)
                .build()

            Log.d("RAW_URL", url.toString())

            return@Interceptor chain.proceed(request)
        }


    @Provides
    @Singleton
    fun provideOkHttpClient(interceptor: Interceptor) =
        /*if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()
        } else*/
        OkHttpClient
            .Builder()
            .addInterceptor(interceptor)
            .build()

    @Provides
    @Singleton
    fun provideRetrofitInstance(okHttpClient: OkHttpClient): ApiService =
        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(AppConstants.BASE_URL_HACKATHON)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

}