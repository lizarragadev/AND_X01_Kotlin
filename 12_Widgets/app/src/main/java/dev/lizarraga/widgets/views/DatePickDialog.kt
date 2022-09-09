package dev.lizarraga.widgets.views

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import dev.lizarraga.widgets.DateTimeInterface
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class DatePickDialog : DialogFragment(), DatePickerDialog.OnDateSetListener {

    private var datePicker: DatePickerDialog? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        return null!!
    }

    override fun onDateSet(dp: DatePicker?, anio: Int, mes: Int, dia: Int) {



    }

    private fun maxRangeDatePicker(): Calendar {
        val fechaMax = "2020-11-07"
        val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        lateinit var cal: Calendar
        try {
            cal = Calendar.getInstance()
            cal.time = sdf.parse(fechaMax)
        } catch(e: ParseException) {
            e.printStackTrace()
        }
        return cal
    }

    private fun minRangeDatePicker(): Calendar {
        val fechaMin = "2020-10-20"
        val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        lateinit var cal: Calendar
        try {
            cal = Calendar.getInstance()
            cal.time = sdf.parse(fechaMin)
        } catch(e: ParseException) {
            e.printStackTrace()
        }
        return cal
    }



}