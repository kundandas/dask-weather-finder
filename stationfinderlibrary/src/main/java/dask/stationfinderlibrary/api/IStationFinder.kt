package dask.stationfinderlibrary.api

interface IStationFinder {

    fun requestStationList(filter: IStationFinderFilter, callback: IStationFinderRequestCallback);

}