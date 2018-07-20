package dask.stationfinderlibrary.implementation

import java.util.*

class StationUtility {

    companion object {
        /**
         * Converts a string literal of format YYYY-MM-DD into a
         * Calendar
         */
        fun parseCalendar(literal: String) : Calendar {
            var c: Calendar = Calendar.getInstance()
            var split: List<String> = literal.split("-")
            c.set(Calendar.YEAR, Integer.parseInt(split[0]))
            c.set(Calendar.MONTH, Integer.parseInt(split[1])-1)
            c.set(Calendar.DAY_OF_MONTH, Integer.parseInt(split[2]))
            return c
        }

        /**
         * Returns a calendar into "YYYY-MM-DD" format
         */
        fun getFormattedDate(calendar: Calendar ) : String {
            return ""+calendar.get(Calendar.YEAR)+"-"+(calendar.get(Calendar.MONTH)+1)+"-"+calendar.get(Calendar.DAY_OF_MONTH)
        }

    }

}