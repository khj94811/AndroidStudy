package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

// Extends 대신에 :을 사용하여 상속을 나타낸다.
class MainActivity : AppCompatActivity() {

    var buttonCount : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        clickButton.setOnClickListener {
            buttonCount = buttonCount xor 1
            if (buttonCount == 1) textView.text = "버튼을 눌렀습니다."
            else textView.text = "버튼을 또 눌렀습니다."
        }
    }
}
