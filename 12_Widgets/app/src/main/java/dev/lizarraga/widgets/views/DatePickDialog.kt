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
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        datePicker = DatePickerDialog(activity as Context, this, year, month, day)
        datePicker?.datePicker?.minDate = minRangeDatePicker().timeInMillis
        datePicker?.datePicker?.maxDate = maxRangeDatePicker().timeInMillis
        return datePicker as DatePickerDialog
    }

    override fun onDateSet(dp: DatePicker?, anio: Int, mes: Int, dia: Int) {
        val mesActual = mes + 1
        val diaFormateado = if(dia < 10) "0$dia" else dia.toString()
        val mesFormateado = if(mesActual < 10) "0$mesActual" else mesActual.toString()
        val resultado = "$diaFormateado/$mesFormateado/$anio"

        (activity as DateTimeInterface).obtieneFecha(resultado)
    }

    private fun maxRangeDatePicker(): Calendar {
        val fechaMax = "2022-09-15"
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
        val fechaMin = "2022-09-09"
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