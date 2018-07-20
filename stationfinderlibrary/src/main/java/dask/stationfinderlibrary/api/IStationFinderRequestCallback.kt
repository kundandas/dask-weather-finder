package dask.stationfinderlibrary.api

import dask.stationfinderlibrary.implementation.Station

interface IStationFinderRequestCallback {

    fun onSuccess(stationList: List<Station>)
    fun onFailure()
}
