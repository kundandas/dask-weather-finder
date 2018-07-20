package dask.stationfinder

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import dask.stationfinderlibrary.Multiplier
import dask.stationfinderlibrary.StationFinder
import dask.stationfinderlibrary.api.IStationFinderRequestCallback

class MainActivity : AppCompatActivity(), IStationFinderRequestCallback {
    override fun onSuccess(stationList: List<String>) {
        Log.d("kundan", "received list of station:")
        for (i in stationList) {
            Log.d("kundan", i)
        }
    }

    override fun onFailure() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    var token = "QtGAUWGoXSsOiuPIFfIYkbLGPoSxqYVg"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var result: Int = Multiplier().multiply(5, 10)
        Log.d("MainActivity", "Result of 5*10 from library is $result")

        var stationFinder = StationFinder
        stationFinder.initialize(token)
        stationFinder.requestStationList(StationFinderFilter(), this)
    }
}
