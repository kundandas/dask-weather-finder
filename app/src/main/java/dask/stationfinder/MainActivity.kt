package dask.stationfinder

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import dask.stationfinderlibrary.api.IStationFinderRequestCallback
import dask.stationfinderlibrary.implementation.Station
import dask.stationfinderlibrary.implementation.StationFinder

class MainActivity : AppCompatActivity(), IStationFinderRequestCallback {

    public val TAG = "MainActivity"

    override fun onSuccess(stationList: List<Station>) {
        Log.d(TAG, "received list of station. Count = ${stationList.size}")
        for (i in stationList) {
            Log.d(TAG, i.toString())
        }
    }

    override fun onFailure() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    var token = "QtGAUWGoXSsOiuPIFfIYkbLGPoSxqYVg"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var stationFinder = StationFinder
        stationFinder.initialize(token)
        stationFinder.requestStationList(StationFinderFilter(), this)
    }
}
