package se.frost.weeknum

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupBindings()
    }

    private fun setupBindings() {
        previosWeekButton.setOnClickListener { toast("Previous") }
        todayButton.setOnClickListener { toast("Today") }
        nextWeekButton.setOnClickListener { toast("Next") }
    }

    private fun toast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
