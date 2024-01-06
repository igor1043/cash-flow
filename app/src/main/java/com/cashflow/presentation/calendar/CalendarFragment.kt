package com.cashflow.com.cashflow.presentation.calendar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.SnapHelper
import com.arjun.horizontalcalendardate.CalendarAdapter
import com.arjun.horizontalcalendardate.CalendarDateModel
import com.cashflow.R
import com.cashflow.com.cashflow.domain.model.MonthData
import com.cashflow.com.cashflow.presentation.utils.EventObserver
import com.cashflow.databinding.FragmentCalendarBinding
import com.cashflow.com.cashflow.presentation.utils.styles.setStatusBarDarkMode
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartModel
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartType
import com.github.aachartmodel.aainfographics.aachartcreator.AASeriesElement
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

@AndroidEntryPoint
class CalendarFragment : Fragment() {

    private lateinit var binding: FragmentCalendarBinding
    private lateinit var calendar: Calendar
    private val calendarViewModel: CalendarViewModel by viewModels()
    private val cal = Calendar.getInstance(Locale.getDefault())
    private val currentDate = Calendar.getInstance(Locale.getDefault())
    private lateinit var adapter: CalendarAdapter
    private val dates = ArrayList<Date>()
    private val calendarList2 = ArrayList<CalendarDateModel>()
    private val sdf = SimpleDateFormat("MMMM yyyy", Locale.getDefault())

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
        setUpAdapter()
        setUpCalendar()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun setupObservers() {
        calendarViewModel.consumerLiveData.observe(
            viewLifecycleOwner,
            EventObserver {
                createChart(it)
            }
        )
        binding.ivCalendarNext.setOnClickListener {
            cal.add(Calendar.MONTH, 1)
            setUpCalendar()
        }
        binding.ivCalendarPrevious.setOnClickListener {
            cal.add(Calendar.MONTH, -1)
            if (cal == currentDate)
                setUpCalendar()
            else
                setUpCalendar()
        }
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

    private fun setUpAdapter() {
        val snapHelper: SnapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(binding.recyclerView)
        adapter = CalendarAdapter { calendarDateModel: CalendarDateModel, position: Int ->
            calendarList2.forEachIndexed { index, calendarModel ->
                calendarModel.isSelected = index == position
            }
            adapter.setData(calendarList2)

        }
        binding.recyclerView.adapter = adapter
    }

    private fun setUpCalendar() {
        val calendarList = ArrayList<CalendarDateModel>()
        binding.textDateMonth.text = sdf.format(cal.time)
        val monthCalendar = cal.clone() as Calendar
        val maxDaysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH)
        dates.clear()
        monthCalendar.set(Calendar.DAY_OF_MONTH, 1)
        while (dates.size < maxDaysInMonth) {
            dates.add(monthCalendar.time)
            calendarList.add(CalendarDateModel(monthCalendar.time))
            monthCalendar.add(Calendar.DAY_OF_MONTH, 1)
        }
        calendarList2.clear()
        calendarList2.addAll(calendarList)
        adapter.setData(calendarList)
    }

}
