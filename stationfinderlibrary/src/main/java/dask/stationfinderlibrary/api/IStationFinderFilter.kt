package dask.stationfinderlibrary.api

import java.util.*

interface IStationFinderFilter {
    fun getExtent(): IBoundedGeolocation
    fun getDatasetId(): DatasetId
    fun getDataTypeId(): DataTypeId
    fun getStartDate(): Calendar
    fun getEndDate(): Calendar
}
