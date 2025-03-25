package wallee.tech.network.di

import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import wallee.tech.network.BuildConfig
import java.util.concurrent.TimeUnit

inline fun <reified T> createWebService(
    okHttpClient: OkHttpClient,
    url: String = BuildConfig.API_URL
): T = Retrofit.Builder()
    .baseUrl(url)
    .client(okHttpClient)
    .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
    .build()
    .create(T::class.java)

val networkModule = module {
    single<Interceptor> {
        HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
            else HttpLoggingInterceptor.Level.NONE
        }
    }

    single {
        OkHttpClient.Builder()
            .connectTimeout(BuildConfig.TIMEOUT, TimeUnit.MILLISECONDS)
            .readTimeout(BuildConfig.TIMEOUT, TimeUnit.MILLISECONDS)
            .addInterceptor(get<Interceptor>())
            .build()
    }
}