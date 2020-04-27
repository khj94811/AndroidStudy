package com.example.flashlight

import android.app.Service
import android.content.Intent
import android.os.IBinder

class TorchService : Service() {
    /* Instance를 얻는 방법으로 onCreate() 콜백 메서드를 사용하는 방법과, by lazy를 사용하는 방법이 존재 */
    private val torch: Torch by lazy {
        Torch(this)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        /* 보통 intent에 action 값을 설정하여 호출 */
        when (intent?.action) {
            "on" -> {
                torch.flashOn()
            }
            "off" -> {
                torch.flashOff()
            }
        }

        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }
}
