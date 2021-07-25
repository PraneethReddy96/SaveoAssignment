import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitGenerator {
    fun <S> createService(serviceClass: Class<S>?): S {
        val retrofit: Retrofit = getInstance()
        return retrofit.create(serviceClass)
    }

    companion object {


        private val httpLoggingInterceptor =
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

        /* returns retrofit instance*/
        fun getInstance(): Retrofit {
            val retrofitBuilder = Retrofit.Builder()
                .baseUrl("https://api.tvmaze.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build())
            return retrofitBuilder.build()
        }
    }
}
