package dask.stationfinder

import dask.stationfinderlibrary.api.IBoundedGeolocation
import dask.stationfinderlibrary.api.IGeolocation

class BoundedGeolocation(private var southwest: IGeolocation, private var northeast: IGeolocation): IBoundedGeolocation {

    override fun getSouthwestBound(): IGeolocation {
        return southwest
    }

    override fun getNortheastBound(): IGeolocation {
        return northeast
    }
}