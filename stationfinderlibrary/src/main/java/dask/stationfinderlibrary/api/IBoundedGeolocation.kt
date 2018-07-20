package dask.stationfinderlibrary.api

interface IBoundedGeolocation {
    fun getSouthwestBound(): IGeolocation
    fun getNortheastBound(): IGeolocation
}
