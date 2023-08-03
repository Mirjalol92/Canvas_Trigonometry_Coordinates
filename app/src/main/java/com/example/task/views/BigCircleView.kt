package com.example.task.views

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

@SuppressLint("ViewConstructor")
class BigCircleView(context: Context, private val radius: Float, private val padding: Float): View(context) {

    private val paint = Paint().apply {
        style = Paint.Style.STROKE
        strokeWidth = 4f
        color = Color.BLACK
        isAntiAlias = true
    }
    override fun onDraw(canvas: Canvas) {
        canvas.drawCircle(radius, radius, radius - padding, paint)
    }
}