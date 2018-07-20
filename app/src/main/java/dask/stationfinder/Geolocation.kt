package dask.stationfinder

import dask.stationfinderlibrary.api.IGeolocation

class Geolocation(private var latInDegree: Double, private var lonInDegree: Double) : IGeolocation {


    override fun getLatitude(): Double {
        return latInDegree
    }

    override fun getLongitude(): Double {
        return lonInDegree
    }
}