package com.example.task.views

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.view.View
import kotlin.math.sqrt

@SuppressLint("ViewConstructor")
class TriAngleView(context: Context, private val r: Float, private val xPosition: Float? = null) : View(context) {

    private val paint =  Paint().apply {
        style = Paint.Style.STROKE
        color = Color.BLACK
        strokeWidth = 4f
        isAntiAlias = true
    }

    override fun onDraw(canvas: Canvas) {
//        canvas.drawCircle(r,r,r,paint)
        val pointRight = r + (r * sqrt(3f) / 2 )
        val pointLeft = r - (r * sqrt(3f) / 2)
        val h = 3*r/2
        x = xPosition ?: 0f
        canvas.drawLines(floatArrayOf(r, 0f, pointRight,h,pointRight,h, pointLeft, h, pointLeft, h,r,0f), paint)
    }
}