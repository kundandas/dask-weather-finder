package dask.stationfinderlibrary.api

import java.util.*

interface IStationFinderFilterBuilder {

    fun addFilter_DatasetId(id: DatasetId) : IStationFinderFilterBuilder
    fun addFilter_DataTypeId(id: DataTypeId) : IStationFinderFilterBuilder
    fun addFilter_StartDate(calendar: Calendar) : IStationFinderFilterBuilder
    fun addFilter_EndDate(calendar: Calendar) : IStationFinderFilterBuilder
    fun addFilter_GeographicExtent(boundedGeolocation: IBoundedGeolocation) : IStationFinderFilterBuilder
    fun addFilter_GeographicExtent(geolocation: IGeolocation, radiusInKM : Double) : IStationFinderFilterBuilder
    fun build() : IStationFinderFilter
}
