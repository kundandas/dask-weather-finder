package dask.stationfinderlibrary.api

import java.util.*

interface IStationFinderFilter {
    fun getDatasetId(): DatasetId
    fun getDataTypeId(): DataTypeId
    fun getStartDate(): Calendar
    fun getEndDate(): Calendar
    fun getExtent(): IBoundedGeolocation
}
