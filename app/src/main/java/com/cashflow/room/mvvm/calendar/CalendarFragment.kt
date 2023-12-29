package com.cashflow.room.mvvm.calendar

import android.annotation.SuppressLint
import android.graphics.Canvas
import android.graphics.Paint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.widget.CalendarView
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.compose.ui.graphics.Color
import androidx.fragment.app.Fragment
import com.cashflow.room.mvvm.utils.styles.setStatusBarDarkMode
import com.cashflow.room.mvvm.R
import com.cashflow.room.mvvm.databinding.FragmentCalendarBinding
import java.util.Calendar

class CalendarFragment : Fragment() {

    private lateinit var binding: FragmentCalendarBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setStatusBarDarkMode(true)

        binding = FragmentCalendarBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this


        binding.calendar.setOnDateChangeListener { view, year, month, dayOfMonth ->
            val selectedDate = "$dayOfMonth/${month + 1}/$year"
            Toast.makeText(requireContext(), "Data selecionada: $selectedDate", Toast.LENGTH_SHORT)
                .show()
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
    }






}


