package com.example.retrofitexample.repo.network
import retrofit2.Call
import retrofit2.http.GET

interface IpApi {
    @GET("json")
    fun getIpInfo(): Call<IpApiResponse>

/*
    @FormUrlEncoded
    @POST("mycode") //  For ex.: if BASE_URL = https://yourserver.com/ (look MainRepo), so request will be:  https://yourserver.com/mycode
    fun codeCheck(
        @Field("code") code_param: String = "",    // code - request field name, code_param - field value
        @Field("apps_id") apps_id_param: String = "",
        @Field("adv_id") ad_id_param: String = "",
        @Field("os_id") os_id_param: String = "",
        @Field("phone") phone_param: String = ""
    ): Call<CodeCheckApiResponse>
    */

}