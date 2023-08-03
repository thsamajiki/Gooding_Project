package com.dnd_9th_3_android.gooding.api

//import com.dnd_9th_3_android.gooding.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object LoginRetrofitUtil {
    private val instance : Retrofit? = null
    private val baseUrl : String = "https://studiogooding.site"
    val loginApiService : LoginRetrofitService by lazy {
        getRetrofit().create(LoginRetrofitService::class.java)
    }

    private fun getRetrofit() : Retrofit{
        val header = Interceptor{
            val original = it.request()
            it.proceed(original)

        }

        if (instance == null){
            return Retrofit.Builder() //객체 생성
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(buildOkHttpClient(header))
                .build()
        }else{
            return instance
        }
    }

    private fun buildOkHttpClient(header:Interceptor) : OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                chain.proceed(chain.request().newBuilder().also {
                    it.addHeader("Accept", "application/json")
                }.build())
            }.also { client ->
                client.addInterceptor(header)
                //로그 기록 인터셉터 등록
                val logInterceptor = HttpLoggingInterceptor()
                logInterceptor.level = HttpLoggingInterceptor.Level.BODY
                client.addInterceptor(logInterceptor)
            }.build()
    }
}