package android.singidunum.ac.rs.ispitrma.modules

import android.content.Context
import android.content.SharedPreferences
import android.singidunum.ac.rs.ispitrma.data.db.ProjectDatabase
import androidx.room.Room
import com.facebook.stetho.okhttp3.BuildConfig
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit


val coreModule = module {
    single<SharedPreferences> {
        androidApplication().getSharedPreferences(androidApplication().packageName, Context.MODE_PRIVATE)
    }

    single { Room.databaseBuilder(androidContext(), ProjectDatabase::class.java, "ProjectDb")
        .fallbackToDestructiveMigration()
        .build() }

    single { createMoshi() }

    single { createOkHttpClient() }

    single { createRetrofit(moshi = get(), httpClient = get()) }
}

fun createMoshi(): Moshi {
    return Moshi.Builder()
        .add(Date::class.java, Rfc3339DateJsonAdapter())
        .build()
}

fun createRetrofit(moshi: Moshi,
                    httpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://api.musixmatch.com/ws/1.1/")
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(MoshiConverterFactory.create(moshi).asLenient())
        .client(httpClient)
        .build()
}

fun createOkHttpClient(): okhttp3.OkHttpClient {
    val httpClient = okhttp3.OkHttpClient.Builder()
    httpClient.readTimeout(60, TimeUnit.SECONDS)
    httpClient.connectTimeout(60, TimeUnit.SECONDS)
    httpClient.writeTimeout(60, TimeUnit.SECONDS)

    if (BuildConfig.DEBUG) {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        httpClient.addInterceptor(logging)
        httpClient.addNetworkInterceptor(StethoInterceptor())
    }

    return httpClient.build()
}

inline fun <reified T> create(retrofit: Retrofit): T  {
    return retrofit.create<T>(T::class.java)
}