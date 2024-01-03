package com.cashflow.com.cashflow.presentation.home.bottomsheet.selectdateperiod

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.cashflow.com.cashflow.presentation.home.HomeViewModel
import com.cashflow.com.cashflow.presentation.utils.EventObserver
import com.cashflow.com.cashflow.presentation.utils.date.Month
import com.cashflow.R
import com.cashflow.databinding.FragmentSelectDatePeriodBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class SelectedDatePeriodBottomSheet : BottomSheetDialogFragment() {
    private val TAG = SelectedDatePeriodBottomSheet::class.java.simpleName
    private lateinit var binding: FragmentSelectDatePeriodBinding
    private lateinit var mBehavior: BottomSheetBehavior<View>

    private val homeViewModel: HomeViewModel by activityViewModels()
    private val selectedDatePeriodViewModel: SelectedDatePeriodViewModel by viewModels()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val inflater = LayoutInflater.from(requireContext())
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_select_date_period,
            view?.findViewById(R.id.bottom_sheet_select_date),
            false
        )
        binding.lifecycleOwner = this
        binding.viewModel = selectedDatePeriodViewModel
        val dialog: BottomSheetDialog =
            super.onCreateDialog(savedInstanceState) as BottomSheetDialog
        val view = binding.root
        dialog.setContentView(view)
        mBehavior = BottomSheetBehavior.from(view.parent as View)
        val bottomSheet = view.parent as View
        bottomSheet.backgroundTintMode = PorterDuff.Mode.CLEAR
        bottomSheet.backgroundTintList = ColorStateList.valueOf(Color.TRANSPARENT)
        bottomSheet.setBackgroundColor(Color.TRANSPARENT)

        homeViewModel.currentMonth.value?.peekContent()?.let { setTextColorMonth(it) }
        homeViewModel.currentYear.value?.peekContent()?.let { setCurrentYearText(it) }

        setupObservers()
        setupClick()
        return dialog
    }

    private fun setupObservers() {
        selectedDatePeriodViewModel.selectMonth.observe(
            this,
            EventObserver {
                clearTextColorMonth()
                setTextColorMonth(it)
            }
        )
    }

    private fun setupClick() {
        binding.buttonNextYear.setOnClickListener {
            var currentYear =
                if (homeViewModel.getCurrentYear() != 0) homeViewModel.getCurrentYear()
                else selectedDatePeriodViewModel.getCurrentYear()
            currentYear += 1
            selectedDatePeriodViewModel.setCurrentYear(currentYear)
            homeViewModel.setCurrentYear(currentYear)
            setCurrentYearText(currentYear)
        }
        binding.buttonAfterYear.setOnClickListener {
            var currentYear =
                if (homeViewModel.getCurrentYear() != 0) homeViewModel.getCurrentYear()
                else selectedDatePeriodViewModel.getCurrentYear()

            currentYear -= 1
            selectedDatePeriodViewModel.setCurrentYear(currentYear)
            homeViewModel.setCurrentYear(currentYear)
            setCurrentYearText(currentYear)
        }

        binding.buttomSelectPeriod.setOnClickListener {
            selectedDatePeriodViewModel.selectMonth.value?.peekContent()
                ?.let { currentMonth -> homeViewModel.setCurrentMonth(currentMonth) }

            selectedDatePeriodViewModel.selectYear.value?.peekContent()
                ?.let { currentYear -> homeViewModel.setCurrentYear(currentYear) }

            mBehavior.state = BottomSheetBehavior.STATE_HIDDEN
        }

        binding.buttonCancell.setOnClickListener {
            mBehavior.state = BottomSheetBehavior.STATE_HIDDEN
        }
    }

    @SuppressLint("ResourceAsColor")
    private fun setTextColorMonth(it: Month) {
        when (it) {
            Month.JANUARY -> {
                binding.jan.setTextColor(resources.getColor(R.color.colorPrimary))
            }
            Month.FEBRUARY -> {
                binding.fev.setTextColor(resources.getColor(R.color.colorPrimary))
            }
            Month.MARCH -> {
                binding.mar.setTextColor(resources.getColor(R.color.colorPrimary))
            }
            Month.APRIL -> {
                binding.abri.setTextColor(resources.getColor(R.color.colorPrimary))
            }
            Month.MAY -> {
                binding.mai.setTextColor(resources.getColor(R.color.colorPrimary))
            }
            Month.JUNE -> {
                binding.jun.setTextColor(resources.getColor(R.color.colorPrimary))
            }
            Month.JULY -> {
                binding.jul.setTextColor(resources.getColor(R.color.colorPrimary))
            }
            Month.AUGUST -> {
                binding.ago.setTextColor(resources.getColor(R.color.colorPrimary))
            }
            Month.SEPTEMBER -> {
                binding.set.setTextColor(resources.getColor(R.color.colorPrimary))
            }
            Month.OCTOBER -> {
                binding.out.setTextColor(resources.getColor(R.color.colorPrimary))
            }
            Month.NOVEMBER -> {
                binding.nov.setTextColor(resources.getColor(R.color.colorPrimary))
            }
            Month.DECEMBER -> {
                binding.dez.setTextColor(resources.getColor(R.color.colorPrimary))
            }
        }
    }

    @SuppressLint("ResourceAsColor")
    fun clearTextColorMonth() {
        binding.jan.setTextColor(resources.getColor(R.color.neutral_60))
        binding.fev.setTextColor(resources.getColor(R.color.neutral_60))
        binding.mar.setTextColor(resources.getColor(R.color.neutral_60))
        binding.abri.setTextColor(resources.getColor(R.color.neutral_60))
        binding.mai.setTextColor(resources.getColor(R.color.neutral_60))
        binding.jun.setTextColor(resources.getColor(R.color.neutral_60))
        binding.jul.setTextColor(resources.getColor(R.color.neutral_60))
        binding.ago.setTextColor(resources.getColor(R.color.neutral_60))
        binding.set.setTextColor(resources.getColor(R.color.neutral_60))
        binding.out.setTextColor(resources.getColor(R.color.neutral_60))
        binding.nov.setTextColor(resources.getColor(R.color.neutral_60))
        binding.dez.setTextColor(resources.getColor(R.color.neutral_60))
    }

    private fun setCurrentYearText(currentYear: Int) {
        binding.year.text = "$currentYear"
    }

    override fun onResume() {
        super.onResume()
        mBehavior.state = BottomSheetBehavior.STATE_EXPANDED
    }

    companion object {
        const val FRAGMENT_TAG = "bottomSheetFragmentMaterialTag"

        fun newInstance(): SelectedDatePeriodBottomSheet {
            return SelectedDatePeriodBottomSheet().apply { }
        }
    }
}
