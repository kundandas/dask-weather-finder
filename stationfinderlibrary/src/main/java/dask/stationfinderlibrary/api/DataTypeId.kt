package dask.stationfinderlibrary.api

enum class DataTypeId(private val value: String) {
    ANN_TMIN_PRBFST_T32FP50("ANN-TMIN-PRBFST-T32FP50");

    fun getValue() : String {
        return this.value
    }
}
