package se.frost.weeknum.util

import java.text.SimpleDateFormat
import java.util.*

/**
 * Weeknum
 * Created by Sergii Nezdolii on 2017-12-07.
 *
 * Copyright (c) 2017 Frost°. All rights reserved.
 */

class WeekFormatter {

    companion object {

        fun weekTitle(date: Date): String {
            return "${DateWeekUtil.weekNumber(date)}"
        }

        fun weekDescription(date: Date): String {
            val startOfTheWeek = DateWeekUtil.getFirstDayOfWeek(date).time
            val endOfTheWeek = DateWeekUtil.getLastDayOfWeek(date).time

            val formatter = SimpleDateFormat("dd MMM", Locale.getDefault())
            return "${formatter.format(startOfTheWeek)} - ${formatter.format(endOfTheWeek)}"
        }
    }
}