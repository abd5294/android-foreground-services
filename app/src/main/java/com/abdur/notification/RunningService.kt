package com.abdur.notification

import android.app.Notification
import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat

class RunningService : Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when(intent?.action){
            Actions.START.toString() -> {
                start()
            }
            Actions.STOP.toString() -> stopSelf()
        }
        return super.onStartCommand(intent, flags, startId)
    }

    private fun start() {
        val notification = NotificationCompat.Builder(this, "notification channel")
            .setContentTitle("Notification")
            .setContentText("Notification from the app")
            .setSmallIcon(R.drawable.baseline_baby_changing_station_24)
            .build()
        startForeground(1, notification)
    }

        enum class Actions {
        START, STOP
    }
}