package dask.stationfinderlibrary.api

interface IStationFinderRequestCallback {

    fun onSuccess(stationList: List<String>)
    fun onFailure()
}
