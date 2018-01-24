package com.example.denisdavidek.kotlintest


import android.content.AsyncTaskLoader
import android.content.Context
import android.os.Bundle
import org.json.JSONObject
import java.net.URL


/**
 * Created by denisdavidek on 1/24/18.
 */
class MainLoader(context: Context, bundle: Bundle) : AsyncTaskLoader<VideoZNatacania>(context) {
    private var currentBundle : Bundle = bundle

    override fun onStartLoading() {
        super.onStartLoading()
        forceLoad()
    }


    override fun loadInBackground(): VideoZNatacania {
     var url = currentBundle.getString("testKey")
/*        var finalUrl : URL = URL(url)*/
  /*   try {
finalUrl = URL(url)
     }catch (e:Exception) {

     }*/

var responseJSONString: String = NetworkUtils.getResponseFromHttp(URL(url))

        var parentJSONObject = JSONObject(responseJSONString)

        var returnedVideoZNatacania = VideoZNatacania(parentJSONObject.getString("url"))

        return returnedVideoZNatacania
    }
}