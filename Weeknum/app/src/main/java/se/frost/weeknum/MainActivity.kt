package se.frost.weeknum

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import se.frost.weeknum.util.DateWeekUtil
import se.frost.weeknum.util.WeekFormatter
import java.util.*

class MainActivity : AppCompatActivity() {

    private var currentDate = Date()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupBindings()
        updateWithDate(currentDate)
    }

    private fun setupBindings() {
        previosWeekButton.setOnClickListener { updateWithDate(DateWeekUtil.previousWeekStart(currentDate)) }
        todayButton.setOnClickListener { updateWithDate(Date()) }
        nextWeekButton.setOnClickListener { updateWithDate(DateWeekUtil.nextWeekStart(currentDate)) }
    }

    private fun updateWithDate(date: Date) {
        currentDate = date
        weekNumberTextView.text = WeekFormatter.weekTitle(date)
        weekDescriptionTextView.text = WeekFormatter.weekDescription(date)
    }
}
