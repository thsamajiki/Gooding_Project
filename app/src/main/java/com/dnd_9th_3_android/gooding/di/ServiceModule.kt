package com.dnd_9th_3_android.gooding.di

import android.util.Log
import com.dnd_9th_3_android.gooding.KakaoMapService
import com.dnd_9th_3_android.gooding.api.baseUrl
import com.dnd_9th_3_android.gooding.api.kakaoMapUrl
import com.dnd_9th_3_android.gooding.data.KakaoMapAddressRemoteDataSource
import com.dnd_9th_3_android.gooding.data.KakaoMapAddressRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.Locale
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class ServiceModule() {
    private var kakaoMapService: KakaoMapService? = null

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor() = HttpLoggingInterceptor { message ->
        Log.d("API", message)
    }.apply {
        setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    @Singleton
    fun provideKakaoApiInterceptor(): ApiInterceptor = ApiInterceptor()

    @Provides
    @Singleton
    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        apiInterceptor: ApiInterceptor
    ): OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(5, TimeUnit.SECONDS)
        .writeTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .addInterceptor(apiInterceptor)
        .addInterceptor(httpLoggingInterceptor)
        .build()

    @Provides
    @Singleton
    fun getClient(
        client: OkHttpClient,
    ): Retrofit = Retrofit.Builder()
        .baseUrl("$kakaoMapUrl/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    @Provides
    @Singleton
    fun getKakaoApiService(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        apiInterceptor: ApiInterceptor
    ): KakaoMapService {
        kakaoMapService?.let {
            return it
        } ?: run {
            val client = OkHttpClient.Builder().connectTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(apiInterceptor)
                .addInterceptor(httpLoggingInterceptor)
                .build()

            kakaoMapService = Retrofit.Builder().baseUrl("$kakaoMapUrl/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
                .create(KakaoMapService::class.java)

            return kakaoMapService!!
        }
    }

    class ApiInterceptor : Interceptor {
        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): Response {
            val request = chain.request().newBuilder()
                .header("Accept-Language", getLanguage())
                .header("Authorization", "a244014544b5323246b6853ca1d8ca93")
                .build()

            return chain.proceed(request)
        }

        private fun getLanguage() = Locale.getDefault().language
    }
}