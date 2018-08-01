package dask.stationfinderlibrary.implementation

import dask.stationfinderlibrary.api.*
import java.util.*

class StationFinderFilter : IStationFinderFilter {


    private lateinit var datasetId : DatasetId
    private lateinit var dataTypeId: DataTypeId
    private lateinit var startDate : Calendar
    private lateinit var endDate : Calendar
    private lateinit var boundedGeolocation: IBoundedGeolocation
    lateinit var geolocation: IGeolocation
    private var radiusInKM: Double = 0.0



    override fun getGeoLocation(): IGeolocation {
        return geolocation
    }

    override fun getRadiusInKM(): Double {
        return radiusInKM
    }

    override fun getExtent(): IBoundedGeolocation {
        return boundedGeolocation
    }

    override fun getDatasetId(): DatasetId {
        return datasetId
    }

    override fun getDataTypeId(): DataTypeId {
        return dataTypeId
    }

    override fun getStartDate(): Calendar {
        return startDate
    }

    override fun getEndDate(): Calendar {
        return endDate
    }

}