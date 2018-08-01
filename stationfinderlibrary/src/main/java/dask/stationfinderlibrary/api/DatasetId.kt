package dask.stationfinderlibrary.api

enum class DatasetId(private var value: String) {


    DAILY_SUMMARIES("GHCND"),
    GLOBAL_SUMMARY_OF_THE_MONTH("GSOM"),
    GLOBAL_SUMMARY_OF_THE_YEAR("GSOY"),
    WEATHER_RADAR_LEVEL_2("NEXRAD2"),
    WEATHER_RADAR_LEVEL_3("NEXRAD3"),
    NORMALS_ANNUAL_SEASONAL("NORMAL_ANN"),
    NORMALS_DAILY("NORMAL_DLY"),
    NORMALS_HOURLY("NORMAL_HLY"),
    NORMALS_MONTHYL("NORMAL_MLY"),
    PRECIPITATION_15_MINUTE("PRECIP_15"),
    PRECIPITATION_HOURLY("PRECIP_HLY");

    fun getValue() : String {
        return this.value
    }
}
