import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.CalendarView
import java.util.*

class CustomCalendarView : CalendarView {

    private val markerDate = Calendar.getInstance().apply {
        set(2023, Calendar.DECEMBER, 13)
    }

    private val markerPaint = Paint().apply {
        color = Color.RED
        style = Paint.Style.FILL
    }

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // Convertendo a data do marcador para a posição Y no CalendarView
        val markerDayOfMonth = markerDate.get(Calendar.DAY_OF_MONTH)
        val markerY = getYFromDay(markerDayOfMonth)

        // Obtendo as coordenadas do dia 13/12/2023
        val x = getXFromDay(markerDayOfMonth)

        // Definindo a posição do marcador na parte inferior do dia
        val markerRadius = 20f // Tamanho do marcador
        val markerBottomY = markerY + markerRadius

        // Desenhando o marcador
        canvas.drawCircle(x, markerBottomY, markerRadius, markerPaint)
    }

    private fun getXFromDay(day: Int): Float {
        val firstDayOfMonth = getFirstDayOfMonth()
        val xOffset = day + firstDayOfMonth - 1
        return xOffset * (width / 7f)
    }

    private fun getYFromDay(day: Int): Float {
        val firstDayOfMonth = getFirstDayOfMonth()
        val yOffset = (day + firstDayOfMonth - 1) / 7
        return yOffset * (height / 6f)
    }

    private fun getFirstDayOfMonth(): Int {
        val calendar = Calendar.getInstance()
        calendar.set(2023, 11, 1)
        return calendar.get(Calendar.DAY_OF_WEEK)
    }
}
