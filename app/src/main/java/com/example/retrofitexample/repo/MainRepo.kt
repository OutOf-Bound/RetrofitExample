package com.example.retrofitexample.repo

import com.example.retrofitexample.BASE_URL_IP_API
import com.example.retrofitexample.repo.network.IpApi
import com.example.retrofitexample.repo.network.IpApiResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MainRepo {
    private val ipApi: IpApi

    init {
        val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        val client: OkHttpClient = OkHttpClient.Builder().apply {
            addInterceptor(interceptor)
        }.build()

        val retrofit_ip = Retrofit.Builder()
            .baseUrl(BASE_URL_IP_API)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        ipApi = retrofit_ip.create(IpApi::class.java)
    }

    fun getInfoByIp(
        onSuccess: (ipInfo: IpApiResponse) -> Unit,
        onError: () -> Unit
    ) {
        ipApi.getIpInfo()
            .enqueue(object : Callback<IpApiResponse> {
                override fun onResponse(
                    call: Call<IpApiResponse>,
                    response: Response<IpApiResponse>
                ) {

                    if (response.isSuccessful) {
                        val responseBody = response.body()

                        if (responseBody != null) {

                            onSuccess.invoke(responseBody)
                        } else {

                            onError.invoke()
                        }
                    } else {

                        onError.invoke()
                    }
                }

                override fun onFailure(call: Call<IpApiResponse>, t: Throwable) {
                    onError.invoke()
                }
            })
    }
/*
    fun checkCode(
        code_param: String,
        apps_id_param: String,
        ad_id_param: String,
        os_id_param: String,
        phone_param: String,
        onSuccess: (codeCheckResult: CodeCheckApiResponse) -> Unit,
        onError: () -> Unit
    ) {
        actionApi.codeCheck(
            code_param,
            apps_id_param,
            ad_id_param,
            os_id_param,
            phone_param
        )
            .enqueue(object : Callback<CodeCheckApiResponse> {
                override fun onResponse(
                    call: Call<CodeCheckApiResponse>,
                    response: Response<CodeCheckApiResponse>
                ) {

                    if (response.isSuccessful) {
                        val responseBody = response.body()

                        if (responseBody != null) {

                            onSuccess.invoke(responseBody)
                        } else {

                            onError.invoke()
                        }
                    } else {

                        onError.invoke()
                    }
                }

                override fun onFailure(call: Call<CodeCheckApiResponse>, t: Throwable) {
                    onError.invoke()
                }
            })
    }

 */
}