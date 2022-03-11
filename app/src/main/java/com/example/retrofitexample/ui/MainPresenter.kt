package com.example.retrofitexample.ui

import com.example.retrofitexample.repo.MainRepo
import com.example.retrofitexample.repo.network.IpApiResponse

class MainPresenter(private val view:MainContract.View):MainContract.Presenter {

    override fun getInfoByIpAddress(){
        Thread {
            fun onIpInfoFetched(ipInfo: IpApiResponse) {
               view.showInfo(ipInfo)
            }

            fun onError() {
                view.showErrorDialog()
            }

            MainRepo.getInfoByIp(
                onSuccess = ::onIpInfoFetched,
                onError = ::onError
            )
        }.start()
    }
/*
    override fun checkCode(
        codeString: String,
        apps_id_param: String,
        ad_id_param: String,
        os_id_param: String,
        phoneString: String
    ) {
        Thread {
            fun onCodeCheckFetched(codeCheckResult: CodeCheckApiResponse) {
                view.routeByCodeCheckResult(codeCheckResult.valid_param)
            }

            fun onError() {
                view.showErrorDialog(NET_ERROR_WHEN_CHECK_CODE)
            }

            MainRepo.checkCode(
                codeString,
                apps_id_param,
                ad_id_param,
                os_id_param,
                phoneString,
                onSuccess = ::onCodeCheckFetched,
                onError = ::onError
            )
        }.start()
    }

 */
}