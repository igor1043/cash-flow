package com.cashflow.com.cashflow.presentation.calendar

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.SnapHelper
import com.arjun.horizontalcalendardate.CalendarAdapter
import com.arjun.horizontalcalendardate.CalendarDateModel
import com.cashflow.R
import com.cashflow.com.cashflow.domain.model.MonthData
import com.cashflow.com.cashflow.presentation.utils.EventObserver
import com.cashflow.com.cashflow.presentation.utils.styles.setStatusBarDarkMode
import com.cashflow.databinding.FragmentCalendarBinding
import com.events.calendar.utils.EventsCalendarUtil.today
import com.events.calendar.views.EventsCalendar
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

@AndroidEntryPoint
class CalendarFragment : Fragment(), EventsCalendar.Callback {

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

                binding.calendar.setOnDateChangeListener { view, year, month, dayOfMonth ->
                    val selectedDate = "$dayOfMonth/${month + 1}/$year"
                    Toast.makeText(requireContext(), "Data selecionada: $selectedDate", Toast.LENGTH_SHORT)
                        .show()
                }
  /*      binding.eventsCalendar.setSelectionMode(binding.eventsCalendar.MULTIPLE_SELECTION) //set mode of Calendar
            .setToday(today) //set today's date [today: Calendar]
            .setWeekStartDay(Calendar.SUNDAY, false) //set start day of the week as you wish [startday: Int, doReset: Boolean]
            .setCurrentSelectedDate(today) //set current date and scrolls the calendar to the corresponding month of the selected date [today: Calendar]
            .setDateTextFontSize(16f) //set font size for dates
            .setMonthTitleFontSize(16f) //set font size for title of the calendar
            .setWeekHeaderFontSize(16f) //set font size for week names
            .setCallback(this)
            .disableDaysInWeek(Calendar.SATURDAY, Calendar.SUNDAY) //disable days in a week on the whole EventsCalendar [varargs days: Int]
            .build()*/
        super.onViewCreated(binding.root, savedInstanceState)
        return binding.root
    }

    override fun onDayLongPressed(selectedDate: Calendar?) {
        Log.e("LONG", "CLICKED")
    }

    override fun onMonthChanged(monthStartDate: Calendar?) {
        Log.e("MON", "CHANGED")
    }

    override fun onDaySelected(selectedDate: Calendar?) {
        Log.e("SHORT", "CLICKED")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupObservers()
        setUpAdapter()
        setUpCalendar()


    }

    private fun setupObservers() {
        calendarViewModel.consumerLiveData.observe(
            viewLifecycleOwner,
            EventObserver {

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
