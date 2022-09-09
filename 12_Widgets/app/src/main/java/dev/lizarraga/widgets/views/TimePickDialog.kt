package dev.lizarraga.widgets.views

import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Context
import android.os.Bundle
import android.text.format.DateFormat
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import dev.lizarraga.widgets.DateTimeInterface
import java.util.*

class TimePickDialog : DialogFragment(), TimePickerDialog.OnTimeSetListener {

    var timePickerDialog: TimePickerDialog? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        return null!!
    }

    override fun onTimeSet(p0: TimePicker?, hora: Int, minuto: Int) {
        val horaFormateada = if(hora < 10) "0$hora" else hora.toString()
        val minutoFormateado = if(minuto < 10) "0$minuto" else minuto.toString()
        val ampm = if(hora < 12) "a.m." else "p.m."
        val resultado = "$horaFormateada:$minutoFormateado $ampm"


    }

}
