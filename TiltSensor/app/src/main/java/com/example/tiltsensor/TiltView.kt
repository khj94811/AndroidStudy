package com.example.tiltsensor

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.hardware.SensorEvent
import android.view.View

class TiltView(context: Context?) : View(context) {
    private val greenPaint: Paint = Paint()
    private val blackPaint: Paint = Paint()

    private var xCoord: Float = 0f
    private var yCoord: Float = 0f

    private var cX: Float = 0f
    private var cY: Float = 0f

    init {
        greenPaint.color = Color.GREEN
        blackPaint.style = Paint.Style.STROKE
        /*  FILL : 색을 채움 (Default)
        *   FILL_AND_STROKE : 획과 관련된 설정을 유지하면서 색을 채움
        *   STROKE : 획 관련 설정을 유지하면서 외곽선만 채움 */
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        cX = w / 2f
        cY = h / 2f
    }

    override fun onDraw(canvas: Canvas?) {
        canvas?.drawCircle(cX, cY, 100f, blackPaint)
        canvas?.drawCircle(cX + xCoord, cY + yCoord, 100f, greenPaint)

        canvas?.drawLine(cX - 20f, cY, cX + 0f, cY, blackPaint)
        canvas?.drawLine(cX, cY -20f, cX, cY + 20f, blackPaint)
    }

    fun onSensorEvent(event: SensorEvent) {
        // 화면을 가로로 돌렸으므로, x축과 y축을 바꿔줄 필요가 있다.
        // 보정값 20을 곱하여 녹색원의 움직임을 알아보기 쉽도록 만들어준다.
        yCoord = event.values[0] * 20
        xCoord = event.values[1] * 20

        // invalidate() : View의 onDraw 메서드를 다시 호출하는 메서드
        invalidate()
    }
}