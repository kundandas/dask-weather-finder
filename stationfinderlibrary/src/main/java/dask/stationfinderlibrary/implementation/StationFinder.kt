package dask.stationfinderlibrary.implementation

import dask.stationfinderlibrary.api.IStationFinder
import dask.stationfinderlibrary.api.IStationFinderFilter
import dask.stationfinderlibrary.api.IStationFinderRequestCallback
import okhttp3.*
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.util.*


object StationFinder : IStationFinder{

    lateinit var token: String
    var serverUrl = "https://www.ncdc.noaa.gov/cdo-web/api/v2/stations"

    fun initialize(token: String) {
        StationFinder.token = token
    }

    override fun requestStationList(filter: IStationFinderFilter, callback: IStationFinderRequestCallback) {
        val client = OkHttpClient()
        var httpUrl: HttpUrl = HttpUrl.Builder()
                .scheme("https")
                .host("ncdc.noaa.gov")
                .addPathSegment("cdo-web")
                .addPathSegment("api")
                .addPathSegment("v2")
                .addPathSegment("stations")
                .addQueryParameter("extent", ""+filter.getExtent().getSouthwestBound().getLatitude() + "," + filter.getExtent().getSouthwestBound().getLongitude() + "," + filter.getExtent().getNortheastBound().getLatitude() + "," + filter.getExtent().getNortheastBound().getLongitude())
                .addQueryParameter("datasetid", filter.getDatasetId().getValue())
                .addQueryParameter("datatypeid", filter.getDataTypeId().getValue())
                .addQueryParameter("startdate", StationUtility.getFormattedDate(filter.getStartDate()))//"2010-01-01"
                .addQueryParameter("enddate", StationUtility.getFormattedDate(filter.getEndDate()))
                .build()
        val request = Request.Builder()
                .url(httpUrl)
                .addHeader("token", token)
                .build()
        client.newCall(request).enqueue(object : Callback{
            override fun onFailure(call: Call?, e: IOException?) {
                call?.cancel()
                callback.onFailure()
            }

            override fun onResponse(call: Call?, response: Response?) {
                callback.onSuccess(parseStationId(response))
            }

        })
    }

    private fun parseStationId(networkResponse: Response?): List<Station> {
        val responseString = networkResponse?.body()?.string()
        val stationIds = ArrayList<Station>()
        try {
            val obj = JSONObject(responseString)
            val resultArray = obj.getJSONArray("results")
            for (i in 0 until resultArray.length()) {
                val resultObject = resultArray.getJSONObject(i)
                var station = Station()
                station.id = resultObject.getString("id")
                station.name = resultObject.getString("name")
                station.elevationUnit = resultObject.getString("elevationUnit")
                station.elevation = resultObject.getDouble("elevation")
                station.latitude = resultObject.getDouble("latitude")
                station.longitude = resultObject.getDouble("longitude")
                station.datacoverage = resultObject.getDouble("datacoverage")
                station.mindate = StationUtility.parseCalendar(resultObject.getString("mindate"))
                station.maxdate = StationUtility.parseCalendar(resultObject.getString("maxdate"))
                stationIds.add(station)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return stationIds
    }


}