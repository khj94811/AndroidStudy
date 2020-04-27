package com.example.flashlight

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val torch = Torch(this)

        flashSwitch.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                torch.flashOn()
            }
            else {
                torch.flashOff()
            }
        }
    }
}
