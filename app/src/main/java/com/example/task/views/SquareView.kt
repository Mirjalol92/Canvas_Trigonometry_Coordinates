package com.example.task.views

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.view.View
import kotlin.math.sqrt

class SquareView(context: Context, private val R: Float, private val r: Float): View(context) {

    private val paint = Paint().apply {
        style = Paint.Style.STROKE
        strokeWidth = 4f
        color = Color.BLACK
        isAntiAlias = true
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        val x = R
        val y = 2*R - r
//        canvas.drawCircle(x, y, r, paint)
        canvas.drawRect(RectF(x-r/ sqrt(2f), y-r/ sqrt(2f), x+r/ sqrt(2f), y+r/ sqrt(2f)), paint)
    }
}