package com.example.task.views

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.view.View

@SuppressLint("ViewConstructor")
class CoordinateView(context: Context, private val width: Float, private val height: Float): View(context) {

    private val pWidth  = 40f
    private val pHeight = pWidth / 2

    private val linePaint = Paint().apply {
        style = Paint.Style.STROKE
        strokeWidth = 4f
        color = Color.BLACK
        isAntiAlias = true
    }

    private val pointerPaint = Paint().apply {
        style = Paint.Style.FILL
        color = Color.BLACK
        isAntiAlias = true
    }
    
    private val pointerXPath = Path().apply {//X pointer
        moveTo(width-pWidth, pHeight) //starting (x, y)
        lineTo(width-pWidth, 0f) // |
        lineTo(width, pHeight) // \
        lineTo( width-pWidth, pHeight + pHeight) // /
        lineTo( width-pWidth, pHeight) // |
        close() // I>
    }

    private val pointerYPath = Path().apply {
        moveTo(pHeight, height-pWidth) // starting (x, y)
        lineTo(pHeight + pHeight, height - pWidth) // -
        lineTo(pHeight, height) // /
        lineTo(0f, height-pWidth) // \
        lineTo(pHeight, height-pWidth) // -
        close() // \/
    }

    override fun onDraw(canvas: Canvas) {
        canvas.drawLine(0f, pHeight, width-pWidth, pHeight, linePaint) // X axis line
        canvas.drawLine(pHeight, 0f,pHeight, height-pWidth, linePaint) // Y axis line
        canvas.drawPath(pointerXPath, pointerPaint)// X axis pointer
        canvas.drawPath(pointerYPath, pointerPaint)// Y axis pointer
    }
}