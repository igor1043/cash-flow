package com.cashflow.com.cashflow.presentation.calendar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cashflow.R
import com.cashflow.databinding.FragmentCalendarBinding
import com.cashflow.com.cashflow.presentation.utils.styles.setStatusBarDarkMode
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartModel
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartType
import com.github.aachartmodel.aainfographics.aachartcreator.AASeriesElement
import java.util.Calendar

class CalendarFragment : Fragment() {

    private lateinit var binding: FragmentCalendarBinding
    private lateinit var calendar: Calendar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        setStatusBarDarkMode(true)

        binding = FragmentCalendarBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this

        /*        binding.calendar.setOnDateChangeListener { view, year, month, dayOfMonth ->
                    val selectedDate = "$dayOfMonth/${month + 1}/$year"
                    Toast.makeText(requireContext(), "Data selecionada: $selectedDate", Toast.LENGTH_SHORT)
                        .show()
                }*/
        createChart()
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    fun createChart() {
        val aaChartModel: AAChartModel = AAChartModel()
            .chartType(AAChartType.Bar)
            .title("title")
            .subtitle("subtitle")
            .backgroundColor(R.color.white)
            .dataLabelsEnabled(true)
            .series(
                arrayOf(
                    AASeriesElement()
                        .name("Tokyo")
                        .data(
                            arrayOf(
                                9.6
                            )
                        ),
                    AASeriesElement()
                        .name("NewYork")
                        .data(
                            arrayOf(
                                2.5
                            )
                        ),
                    AASeriesElement()
                        .name("London")
                        .data(
                            arrayOf(
                                1.0
                            )
                        ),
                    AASeriesElement()
                        .name("Berlin")
                        .data(
                            arrayOf(
                                4.8
                            )
                        )
                )
            )
        binding.aaChartView.aa_drawChartWithChartModel(aaChartModel)
    }
}
