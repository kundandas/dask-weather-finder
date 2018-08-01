package dask.stationfinderlibrary.implementation

import dask.stationfinderlibrary.api.*
import java.util.*

class StationFinderFilter : IStationFinderFilter {

    lateinit var datasetId : DatasetId
    lateinit var dataTypeId: DataTypeId
    lateinit var startDate : Calendar
    lateinit var endDate : Calendar
    lateinit var boundedGeolocation: IBoundedGeolocation
    lateinit var geolocation: IGeolocation
    var radiusInKM: Double = 0.0
}