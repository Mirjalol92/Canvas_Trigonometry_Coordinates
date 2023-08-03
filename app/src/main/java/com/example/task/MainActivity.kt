package com.example.task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.task.views.BigCircleView
import com.example.task.views.CoordinateView
import com.example.task.views.SquareView
import com.example.task.views.TriAngleView
import com.google.android.material.slider.RangeSlider
import kotlin.math.cos
import kotlin.math.sin

class MainActivity : AppCompatActivity() {

    private val canvasContainer: ConstraintLayout by lazy {
        findViewById(R.id.canvasContainer)
    }

    private val valueSlider: RangeSlider by lazy {
        findViewById(R.id.valueSlider)
    }

    private val r: Float by lazy {
        TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30f, resources.displayMetrics)
    }

    private val size: Float by lazy {
        TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 400f, resources.displayMetrics)
    }

    private val bigR: Float by lazy {
        size / 2
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val triAngleView = TriAngleView(this, r, bigR - r)
        val squareView = SquareView(this, bigR, r)
        val circleView = BigCircleView(this, bigR, r)
        val coordinateView = CoordinateView(this, size, size)

        canvasContainer.addView(coordinateView)
        canvasContainer.addView(circleView)
        canvasContainer.addView(triAngleView)
        canvasContainer.addView(squareView)
        valueSlider.valueFrom = 0f
        valueSlider.valueTo = 360f

        valueSlider.addOnChangeListener { slider, value, fromUser ->
            //Triangle (x,y) f(x) = x + x * sin(&), f(y) = y - y * cos(&)
            val tx = (bigR-r) + ((bigR-r) * sin(value * Math.PI / 180))
            val ty = (bigR-r) - ((bigR-r) * cos(value * Math.PI / 180))
            triAngleView.apply {
                this.x = tx.toFloat()
                this.y = ty.toFloat()
            }

            //Square (x,y) f(x) = - x * sin(&), f(y) = y + y * sin(270 - &)
            val sx = - ((bigR-r) * sin(value * Math.PI / 180))
            val sy = (bigR-r) + ((bigR-r) * sin((270-value) * Math.PI / 180))
            squareView.apply {
                this.x = sx.toFloat()
                this.y = -sy.toFloat()
            }
            Log.d("Shapes", "sx = ${sx}, sy = ${sy} sin = ${sin(value)}")
        }

    }
}