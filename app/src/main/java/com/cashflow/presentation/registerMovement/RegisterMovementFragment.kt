package com.cashflow.com.cashflow.presentation.registerMovement

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cashflow.R
import com.cashflow.databinding.FragmentCalendarBinding
import com.cashflow.com.cashflow.presentation.utils.styles.setStatusBarDarkMode
import com.cashflow.databinding.FragmentRegisterMovementBinding
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartModel
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartType
import com.github.aachartmodel.aainfographics.aachartcreator.AASeriesElement
import java.util.Calendar

class RegisterMovementFragment : Fragment() {

    private lateinit var binding: FragmentRegisterMovementBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        setStatusBarDarkMode(true)

        binding = FragmentRegisterMovementBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}
