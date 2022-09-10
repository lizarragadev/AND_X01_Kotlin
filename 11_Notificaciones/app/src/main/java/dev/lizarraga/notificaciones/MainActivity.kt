package dev.lizarraga.notificaciones

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.*
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import androidx.core.app.NotificationCompat
import androidx.core.content.getSystemService
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

        mNotificationManager = applicationContext
            .getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val importancia = NotificationManager.IMPORTANCE_DEFAULT
            val canal = NotificationChannel(CANAL_ID, CANAL_NOMBRE, importancia)
            canal.description = CANAL_DESCRIPCION
            canal.enableLights(true)
            canal.enableVibration(true)
            canal.lockscreenVisibility = NotificationCompat.VISIBILITY_PUBLIC
            mNotificationManager.createNotificationChannel(canal)
        }

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
        val notificacion = NotificationCompat.Builder(context, CANAL_ID)
        notificacion
            .setContentTitle("Titulo Notificacion")
            .setContentText("Espacio para la descripcion de la notificacion la descripcion de la notificacion la descripcion de la notificacion la descripcion de la notificacion")
            .setSmallIcon(R.drawable.ic_android)
            .setLargeIcon(BitmapFactory.decodeResource(context.resources, R.drawable.ic_android))
            .setSubText("Este es un subtext")

        val intent = Intent(context, ResultadoActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(context, 0, intent, 0)
        notificacion.setContentIntent(pendingIntent)

        //notificacion.setOngoing(true)
        notificacion.setAutoCancel(true)

        mNotificationManager.notify(NOTIFICATION_ID, notificacion.build())
    }

    private fun createExpandableNotification(context: Context) {
        val notificacion = NotificationCompat.Builder(context, CANAL_ID)
        notificacion.setSmallIcon(R.drawable.ic_android)
        notificacion.setLargeIcon(BitmapFactory.decodeResource(context.resources, R.drawable.ic_android))
        notificacion.setContentTitle("Titulo comprimido")
        notificacion.setContentText("Aca colocamos en contenido de la notificacion")

        val lorem = context.resources.getString(R.string.long_lorem)
        val inboxStyle = NotificationCompat.InboxStyle()
        val content = lorem.split("\\.".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        for(line in content) {
            inboxStyle.addLine(line)
        }
        inboxStyle.setBigContentTitle("Titulo expandido")
        notificacion.setStyle(inboxStyle)
        mNotificationManager.notify(NOTIFICATION_ID, notificacion.build())
    }

    private fun createBigImageNotification(context: Context) {
        val notificacion = NotificationCompat.Builder(context, CANAL_ID)
        notificacion.setSmallIcon(R.drawable.ic_android)
        notificacion.setLargeIcon(BitmapFactory.decodeResource(context.resources, R.drawable.ic_android))
        notificacion.setContentTitle("Expandible")
        notificacion.setContentText("Aca colocamos en contenido de la notificacion")

        val bigPictureStyle = NotificationCompat.BigPictureStyle()
        bigPictureStyle.bigPicture(BitmapFactory.decodeResource(context.resources, R.drawable.banner))
        notificacion.setStyle(bigPictureStyle)
        mNotificationManager.notify(NOTIFICATION_ID, notificacion.build())
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

        notificacion.addAction(R.drawable.ic_android, "Responder", pendingIntent)
        notificacion.addAction(R.drawable.ic_android, "Ignorar", pendingIntent)

        mNotificationManager.notify(NOTIFICATION_ID, notificacion.build())
    }

}