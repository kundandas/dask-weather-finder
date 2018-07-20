package dask.stationfinder

import dask.stationfinderlibrary.api.*
import java.util.*

class StationFinderFilter : IStationFinderFilter {
    override fun getDatasetId(): DatasetId {
        return DatasetId.NORMAL_ANN
    }

    override fun getDataTypeId(): DataTypeId {
        return DataTypeId.ANN_TMIN_PRBFST_T32FP50
    }

    override fun getStartDate(): Calendar {
        var result: Calendar = Calendar.getInstance()
        result.set(2010, 0, 1)
        return result
    }

    override fun getEndDate(): Calendar {
        return getStartDate()
    }

    override fun getExtent(): IBoundedGeolocation {
        var geolocationSouthWest: IGeolocation = Geolocation(37.307479,-121.9368571)
        var geolocationNorthEast: IGeolocation = Geolocation(37.3749269,-121.870558)
        var bounded: IBoundedGeolocation = BoundedGeolocation(geolocationSouthWest, geolocationNorthEast)
        return bounded
    }
}