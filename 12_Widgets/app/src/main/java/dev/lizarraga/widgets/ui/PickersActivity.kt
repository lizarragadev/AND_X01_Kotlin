package dev.lizarraga.widgets.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.lizarraga.widgets.DateTimeInterface
import dev.lizarraga.widgets.databinding.ActivityPickersBinding
import dev.lizarraga.widgets.views.DatePickDialog
import dev.lizarraga.widgets.views.TimePickDialog

class PickersActivity : AppCompatActivity(), DateTimeInterface {
    lateinit var binding: ActivityPickersBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPickersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ibFecha.setOnClickListener {
            showDatePickerDialog()
        }

        binding.ibHora.setOnClickListener {
            showTimePickerDialog()
        }
    }

    private fun showDatePickerDialog() {
        val dialogFragment = DatePickDialog()
        dialogFragment.show(supportFragmentManager, "datePicker")
    }

    private fun showTimePickerDialog() {
        val dialogFragment = TimePickDialog()
        dialogFragment.show(supportFragmentManager, "timePicker")
    }

    override fun obtieneFecha(date: String) {
        binding.etFecha.setText(date)
    }

    override fun obtieneHora(hora: String) {
        binding.etHora.setText(hora)
    }

}