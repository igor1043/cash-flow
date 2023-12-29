package com.cashflow.calendar

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.CalendarView
import java.util.*

class CustomCalendarView : CalendarView {

    private val markerPaint = Paint()

    // Defina a data para a qual você deseja adicionar o marcador
    private val markedDate = Calendar.getInstance().apply {
        set(2023, Calendar.DECEMBER, 13)
    }

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    private fun init() {
        markerPaint.color = Color.RED
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // Verifique se a data atual é a data marcada
        val currentCalendar = Calendar.getInstance()
        currentCalendar.timeInMillis = date

        if (currentCalendar.get(Calendar.YEAR) == markedDate.get(Calendar.YEAR) &&
            currentCalendar.get(Calendar.MONTH) == markedDate.get(Calendar.MONTH) &&
            currentCalendar.get(Calendar.DAY_OF_MONTH) == markedDate.get(Calendar.DAY_OF_MONTH)
        ) {
            drawMarker(canvas)
        }
    }

    private fun drawMarker(canvas: Canvas) {
        val dayMillis = 24 * 60 * 60 * 1000 // Milissegundos em um dia

        // Calcule as coordenadas x e y do marcador
        val x = (width / 7) * (markedDate.get(Calendar.DAY_OF_WEEK) - 1)
        val y = height - paddingBottom.toFloat()

        // Desenhe um círculo vermelho como marcador
        canvas.drawCircle((x + (width / 7) / 2).toFloat(), y, 16f, markerPaint)
    }
}