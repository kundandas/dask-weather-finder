package dask.stationfinder

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import dask.stationfinderlibrary.api.*
import dask.stationfinderlibrary.implementation.Station
import dask.stationfinderlibrary.implementation.StationFinder
import dask.stationfinderlibrary.implementation.StationFinderFilterBuilder
import java.util.*

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
        val startDate: Calendar = Calendar.getInstance()
        startDate.set(2010, 0, 1)
        val endDate: Calendar = Calendar.getInstance()
        endDate.set(2010, 0, 1)
        var geolocationSouthWest: IGeolocation = Geolocation(37.307479,-121.9368571)
        var geolocationNorthEast: IGeolocation = Geolocation(37.3749269,-121.870558)
        var bounded: IBoundedGeolocation = BoundedGeolocation(geolocationSouthWest, geolocationNorthEast)

        var builder: IStationFinderFilterBuilder = StationFinderFilterBuilder()
        val filter : IStationFinderFilter = builder.addFilter_DatasetId(DatasetId.NORMAL_ANN)
                .addFilter_DataTypeId(DataTypeId.ANN_TMIN_PRBFST_T32FP50)
                .addFilter_StartDate(startDate)
                .addFilter_EndDate(endDate)
                .addFilter_GeographicExtent(bounded)
                .build()
        stationFinder.requestStationList(filter, this)
    }
}
