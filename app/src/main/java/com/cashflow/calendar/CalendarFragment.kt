package com.cashflow.calendar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.cashflow.databinding.FragmentCalendarBinding
import com.cashflow.utils.styles.setStatusBarDarkMode

class CalendarFragment : Fragment() {

    private lateinit var binding: FragmentCalendarBinding

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
