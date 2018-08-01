package dask.stationfinderlibrary.implementation

import dask.stationfinderlibrary.api.*
import java.util.*

class StationFinderFilterBuilder : IStationFinderFilterBuilder {

    lateinit var stationFinderFilter : StationFinderFilter

    constructor() {
        stationFinderFilter = StationFinderFilter()
    }


    override fun addFilter_DatasetId(id: DatasetId): IStationFinderFilterBuilder {
        stationFinderFilter.datasetId = id
        return this
    }

    override fun addFilter_DataTypeId(id: DataTypeId): IStationFinderFilterBuilder {
        stationFinderFilter.dataTypeId = id
        return this
    }

    override fun addFilter_StartDate(calendar: Calendar): IStationFinderFilterBuilder {
        stationFinderFilter.startDate = calendar
        return this
    }

    override fun addFilter_EndDate(calendar: Calendar): IStationFinderFilterBuilder {
        stationFinderFilter.endDate = calendar
        return this
    }

    override fun addFilter_GeographicExtent(boundedGeolocation: IBoundedGeolocation): IStationFinderFilterBuilder {
        stationFinderFilter.boundedGeolocation = boundedGeolocation
        return this
    }

    override fun addFilter_GeographicExtent(geolocation: IGeolocation, radiusInKM: Double): IStationFinderFilterBuilder {
        stationFinderFilter.geolocation = geolocation
        stationFinderFilter.radiusInKM = radiusInKM
        return this
    }

    override fun build(): IStationFinderFilter {
        return stationFinderFilter
    }

}