package com.cashflow.com.cashflow.presentation.registerMovement

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.cashflow.R
import com.cashflow.com.cashflow.presentation.home.HomeViewModel
import com.cashflow.databinding.FragmentCalendarBinding
import com.cashflow.com.cashflow.presentation.utils.styles.setStatusBarDarkMode
import com.cashflow.databinding.FragmentRegisterMovementBinding
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartModel
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartType
import com.github.aachartmodel.aainfographics.aachartcreator.AASeriesElement
import dagger.hilt.android.AndroidEntryPoint
import java.util.Calendar

@AndroidEntryPoint
class RegisterMovementFragment : Fragment() {

    private lateinit var binding: FragmentRegisterMovementBinding
    private val registerViewModel: RegisterMovementViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        registerViewModel.mockFinances()
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
