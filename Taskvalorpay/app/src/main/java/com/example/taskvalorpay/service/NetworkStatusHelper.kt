package com.example.taskvalorpay.service

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import androidx.lifecycle.LiveData


class NetworkStatusHelper(private val context: Context) : LiveData<Boolean>() {

    val valideNetworkConnections : ArrayList<Network> = ArrayList()
    var connectivityManager: ConnectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    private lateinit var connectivityManagerCallback: ConnectivityManager.NetworkCallback

    fun announceStatus(boolean: Boolean){
//        if (valideNetworkConnections.isNotEmpty()){
//            postValue(true)
//        } else {
//            postValue(false)
//        }
        if (boolean){
            postValue(true)
        } else {
            postValue(false)
        }
    }

    fun getConnectivityManagerCallback() =
        object : ConnectivityManager.NetworkCallback(){
            override fun onAvailable(network: Network) {
                super.onAvailable(network)
                val networkCapability = connectivityManager.getNetworkCapabilities(network)
                val hasNetworkConnection = networkCapability?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)?:false
                if (hasNetworkConnection){
                   // valideNetworkConnections.add(network)
                    announceStatus(true)
                }
            }

            override fun onLost(network: Network) {
                super.onLost(network)
               // valideNetworkConnections.remove(network)
                announceStatus(false)
            }

            override fun onCapabilitiesChanged(network: Network, networkCapabilities: NetworkCapabilities) {
                super.onCapabilitiesChanged(network, networkCapabilities)
                if (networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)){
                  //  valideNetworkConnections.add(network)
                    announceStatus(true)
                } else {
                    //valideNetworkConnections.remove(network)
                    announceStatus(false)
                }

            }
        }


    override fun onActive() {
        super.onActive()
        connectivityManagerCallback = getConnectivityManagerCallback()
        val networkRequest = NetworkRequest
            .Builder()
            .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            .build()
        connectivityManager.registerNetworkCallback(networkRequest, connectivityManagerCallback)
    }

    override fun onInactive() {
        super.onInactive()
        connectivityManager.unregisterNetworkCallback(connectivityManagerCallback)
    }


}