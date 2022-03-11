package com.example.retrofitexample.ui

import com.example.retrofitexample.repo.network.IpApiResponse

class MainContract {
    interface  View{

        fun showInfo(info: IpApiResponse)
        fun showErrorDialog()
    }
    interface  Presenter {
        fun getInfoByIpAddress()

    }
}