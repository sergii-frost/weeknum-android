package se.frost.weeknum.util

import java.util.*

/**
 * Weeknum
 * Created by Sergii Nezdolii on 2017-12-07.
 *
 * Copyright (c) 2017 Frost°. All rights reserved.
 */

class DateWeekUtil {

    //This is to be used in order to mimic "static" methods
    companion object {

        fun weekNumber(date: Date) : Int {
            val calendar = Calendar.getInstance()
            calendar.time = date

            return calendar.get(Calendar.WEEK_OF_YEAR)
        }

        fun nextWeekStart(date: Date) : Date {
            val calendar = getFirstDayOfWeek(date)
            calendar.add(Calendar.WEEK_OF_YEAR, 1)

            return calendar.time
        }

        fun previousWeekStart(date: Date) : Date {
            val calendar = getFirstDayOfWeek(date)
            calendar.add(Calendar.WEEK_OF_YEAR, -1)

            return calendar.time
        }

        fun getFirstDayOfWeek(date: Date) : Calendar {
            val calendar = Calendar.getInstance()
            calendar.time = date
            calendar.clear(Calendar.HOUR_OF_DAY)
            calendar.clear(Calendar.MINUTE)
            calendar.clear(Calendar.SECOND)
            calendar.clear(Calendar.MILLISECOND)
            calendar.set(Calendar.DAY_OF_WEEK, calendar.firstDayOfWeek)

            return calendar
        }

        fun getLastDayOfWeek(date: Date) : Calendar {
            val calendar = getFirstDayOfWeek(date)
            calendar.add(Calendar.WEEK_OF_YEAR, 1)
            calendar.add(Calendar.MILLISECOND, -1)

            return calendar
        }

    }
}