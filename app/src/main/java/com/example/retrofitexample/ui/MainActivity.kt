package com.example.retrofitexample.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.retrofitexample.APP_STATE_IDLE
import com.example.retrofitexample.APP_STATE_LOADING
import com.example.retrofitexample.DIALOG_TYPE_ERROR
import com.example.retrofitexample.R
import com.example.retrofitexample.databinding.ActivityMainBinding
import com.example.retrofitexample.repo.network.IpApiResponse
import com.example.retrofitexample.utils.MessageUtils

class MainActivity : AppCompatActivity(), MainContract.View {
    private lateinit var vb: ActivityMainBinding
    private lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb.root)
        presenter = MainPresenter(this)

        vb.mainButton.setOnClickListener {
            getInfo()
        }
    }

    private fun getInfo(){
        setState(APP_STATE_LOADING)
        presenter.getInfoByIpAddress()
    }

    override fun showInfo(info: IpApiResponse){
        setState(APP_STATE_IDLE)
        vb.mainText.setText("")
        vb.mainText.setText(info.toString())
    }

    override fun showErrorDialog() {
        setState(APP_STATE_IDLE)
        val errorDialog = MessageUtils.getDialogShape(
            this,
            getString(R.string.error_occurred),
            getString(R.string.try_again),
            DIALOG_TYPE_ERROR
        )
        errorDialog.setPositiveButton(getString(R.string.again)) { dialog, which ->
            presenter.getInfoByIpAddress()
        }
        errorDialog.show()
    }

    private fun setState(state: Int){
        when(state){
            APP_STATE_IDLE->{
                hideLoading()
            }
            APP_STATE_LOADING->{
                showLoading()
            }
        }

    }

    private fun showLoading(){
        vb.loadingLayout.visibility = View.VISIBLE
    }
    private fun hideLoading(){
        vb.loadingLayout.visibility = View.GONE
    }

}