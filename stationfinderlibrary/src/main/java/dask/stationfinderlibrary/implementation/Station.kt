package dask.stationfinderlibrary.implementation

import java.util.*

class Station {
    var elevation: Double = 0.0
    lateinit var mindate: Calendar
    lateinit var maxdate: Calendar
    var latitude: Double = 0.0
    var longitude: Double = 0.0
    lateinit var name: String
    var datacoverage: Double = 0.0
    lateinit var id: String
    lateinit var elevationUnit: String

    public override fun toString(): String {
        var stringBuffer = StringBuffer()
        stringBuffer.append("elevation=$elevation;")
        stringBuffer.append("mindate=${StationUtility.getFormattedDate(mindate)};")
        stringBuffer.append("maxdate=${StationUtility.getFormattedDate(maxdate)};")
        stringBuffer.append("latitude=$latitude;")
        stringBuffer.append("longitude=$longitude;")
        stringBuffer.append("name=$name;")
        stringBuffer.append("datacoverage=$datacoverage;")
        stringBuffer.append("id=$id;")
        stringBuffer.append("elevationUnit=$elevationUnit;")
        return stringBuffer.toString()
    }
}