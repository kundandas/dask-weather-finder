package dask.stationfinderlibrary.api

enum class DatasetId(private var value: String) {

    NORMAL_ANN("NORMAL_ANN");

    fun getValue() : String {
        return this.value
    }
}
