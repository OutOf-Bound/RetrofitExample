package com.example.retrofitexample.repo.network

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.lang.StringBuilder

data class IpApiResponse(
    @SerializedName("status")
    val status: String?,
    @SerializedName("country")
    val country: String?,
    @SerializedName("countryCode")
    val countryCode: String?,
    @SerializedName("region")
    val region: String?,
    @SerializedName("regionName")
    val regionName: String?,
    @SerializedName("city")
    val city: String?,
    @SerializedName("zip")
    val zip: String?,
    @SerializedName("lat")
    val lat: Double?,
    @SerializedName("lon")
    val lon: Double?,
    @SerializedName("timezone")
    val timezone: String?,
    @SerializedName("isp")
    val isp: String?,
    @SerializedName("org")
    val org: String?,
    @SerializedName("aS")
    val aS: String?,
    @SerializedName("query")
    val query: String?
):Serializable{
    override fun toString(): String {

        val string: StringBuilder = StringBuilder()
        string.appendLine("Status: $status")
        string.appendLine("Country: $country")
        string.appendLine("Country Code: $countryCode")
        string.appendLine("Region: $region")
        string.appendLine("Region Name: $regionName")
        string.appendLine("City: $city")
        string.appendLine("Zip: $zip")
        string.appendLine("Latitude: $lat") 
        string.appendLine("Longitude: $lon")
        string.appendLine("Time Zone: $timezone")
        string.appendLine("ISP: $isp")
        string.appendLine("Org: $org")
        string.appendLine("AS: $aS")
        string.appendLine("Query: $query")

        return string.toString()
        
    }
}