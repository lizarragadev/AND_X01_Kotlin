package dev.lizarraga.notificaciones

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.ContentResolver
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.media.RingtoneManager
import android.net.Uri
import android.os.*
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import androidx.core.app.NotificationCompat
import dev.lizarraga.notificaciones.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityMainBinding

    lateinit var mNotificationManager: NotificationManager
    val CANAL_ID = "miCanal01"
    val CANAL_NOMBRE = "Mi Canal de Notificaciones"
    val CANAL_DESCRIPCION = "Este es una canal para mis notificaciones"
    val NOTIFICATION_ID = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




        binding.btnNotificacionSimple.setOnClickListener(this)
        binding.btnNotificacionGrande.setOnClickListener(this)
        binding.btnNotificacionAcciones.setOnClickListener(this)
        binding.btnNotificacionImagenGrande.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnNotificacionSimple -> createSimpleNotification(this)
            R.id.btnNotificacionGrande -> createExpandableNotification(this)
            R.id.btnNotificacionImagenGrande -> createBigImageNotification(this)
            R.id.btnNotificacionAcciones -> createButtonNotification(this)
        }
    }

    private fun createSimpleNotification(context: Context) {



    }

    fun playNotificationSound() {
        try {
            //val alarmaSonido = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
            val alarmaSonido = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + applicationContext.packageName + "/"+ R.raw.iphone_notificacion)
            val r = RingtoneManager.getRingtone(applicationContext, alarmaSonido)
            r.play()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun createExpandableNotification(context: Context) {
        val notificacion = NotificationCompat.Builder(context, CANAL_ID)
        notificacion.setSmallIcon(R.drawable.ic_android)
        notificacion.setLargeIcon(BitmapFactory.decodeResource(context.resources, R.drawable.ic_android))
        notificacion.setContentTitle("Expandible")
        notificacion.setContentText("Aca colocamos en contenido de la notificacion")

        val lorem = context.resources.getString(R.string.long_lorem)



    }

    private fun createBigImageNotification(context: Context) {
        val notificacion = NotificationCompat.Builder(context, CANAL_ID)
        notificacion.setSmallIcon(R.drawable.ic_android)
        notificacion.setLargeIcon(BitmapFactory.decodeResource(context.resources, R.drawable.ic_android))
        notificacion.setContentTitle("Expandible")
        notificacion.setContentText("Aca colocamos en contenido de la notificacion")


    }

    private fun createButtonNotification(context: Context) {
        val notificacion = NotificationCompat.Builder(context, CANAL_ID)
        notificacion.setSmallIcon(R.drawable.ic_android)
        notificacion.setLargeIcon(BitmapFactory.decodeResource(context.resources, R.drawable.ic_android))
        notificacion.setContentTitle("Botones")
        notificacion.setContentText("Aca colocamos en contenido de la notificacion")

        val intent = Intent(context, ResultadoActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(context, 0, intent, 0)
        notificacion.setContentIntent(pendingIntent)


    }


}