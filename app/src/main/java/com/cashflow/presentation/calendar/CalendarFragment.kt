package com.cashflow.com.cashflow.presentation.calendar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.cashflow.R
import com.cashflow.com.cashflow.domain.model.MonthData
import com.cashflow.com.cashflow.presentation.utils.EventObserver
import com.cashflow.com.cashflow.presentation.utils.color.generateRandomColor
import com.cashflow.databinding.FragmentCalendarBinding
import com.cashflow.com.cashflow.presentation.utils.styles.setStatusBarDarkMode
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartModel
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartType
import com.github.aachartmodel.aainfographics.aachartcreator.AASeriesElement
import dagger.hilt.android.AndroidEntryPoint
import java.util.Calendar

@AndroidEntryPoint
class CalendarFragment : Fragment() {

    private lateinit var binding: FragmentCalendarBinding
    private lateinit var calendar: Calendar
    private val calendarViewModel: CalendarViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        calendarViewModel.getMockLastMovements()
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
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupObservers()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun setupObservers() {
        calendarViewModel.consumerLiveData.observe(
            viewLifecycleOwner,
            EventObserver {
                createChart(it)
            }
        )
    }

    fun createChart(monthData: List<MonthData>) {
        val list: MutableList<AASeriesElement> = mutableListOf()
        monthData.forEach {
            list.add(
                AASeriesElement()
                    .name(it.month.brazilianName)
                    .data(
                        arrayOf(
                            it.values
                        )
                    )
            )
        }

        val aaChartModel: AAChartModel = AAChartModel()
            .chartType(AAChartType.Column)
            .title("Gastos Anuais")
            .subtitle("total de gastos realizado no ano")
            .backgroundColor(R.color.white)
            .dataLabelsEnabled(false)
            .series(
                list.toTypedArray()
            )
        binding.aaChartView.aa_drawChartWithChartModel(aaChartModel)
    }
}
