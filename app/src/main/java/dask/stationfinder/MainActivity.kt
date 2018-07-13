package dask.stationfinder

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import dask.stationfinderlibrary.Multiplier

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var result: Int = Multiplier().multiply(5, 10)
        Log.d("MainActivity", "Result of 5*10 from library is $result")
    }
}
