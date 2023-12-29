package com.cashflow.room.mvvm.home

import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.cashflow.room.mvvm.home.adapter.MovementsAdapter
import com.cashflow.room.mvvm.home.adapter.SpendingByCategoryAdapter
import com.cashflow.room.mvvm.home.bottomsheet.selectdateperiod.SelectedDatePeriodBottomSheet
import com.cashflow.room.mvvm.home.bottomsheet.selectmovement.SelectedMovementBottomSheet
import com.cashflow.room.mvvm.home.mock.MockMovements
import com.cashflow.room.mvvm.home.mock.MockSpendingCategory
import com.cashflow.room.mvvm.utils.EventObserver
import com.cashflow.room.mvvm.utils.date.getCurrentMonth
import com.cashflow.room.mvvm.utils.date.getCurrentYear
import com.cashflow.room.mvvm.utils.styles.setStatusBarDarkMode
import com.cashflow.room.mvvm.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.navigation_view.view.*

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var spendingByCategoryAdapter: SpendingByCategoryAdapter
    private lateinit var movementsAdapter: MovementsAdapter

    private val homeViewModel: HomeViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        homeViewModel.setCurrentMonth(getCurrentMonth())
        homeViewModel.setCurrentYear(getCurrentYear())
        super.onCreate(savedInstanceState)
    }

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setStatusBarDarkMode(true)

        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        spendingByCategoryAdapter = SpendingByCategoryAdapter()
        spendingByCategoryAdapter.submitList(MockSpendingCategory.createListItens(requireContext()))
        binding.spendingCategory.recycleView.adapter = spendingByCategoryAdapter

        movementsAdapter = MovementsAdapter()
        movementsAdapter.submitList(MockMovements.createListMovements())
        binding.moviments.recycleView.adapter = movementsAdapter

        setupClick()
        setupObservers()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun setupClick() {
        binding.principalCard.bottomDatePeriod.setOnClickListener {
            startFragmentSelectedDatePeriodBottomSheet()

            doubleClick(binding.principalCard.bottomDatePeriod)
        }
        binding.toolbar.icMenu.setOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.START, true)
        }
        binding.createMovement.setOnClickListener {
            startFragmentSelectedMovementBottomSheet()
        }
        binding.buttonsHome.buttonPurchasesHistoric.setOnClickListener {
            navigateToCalendar()
        }
    }

    private fun setupObservers() {
        homeViewModel.currentMonth.observe(
            viewLifecycleOwner,
            EventObserver {
                binding.principalCard.mouth.text = it.brazilianName
            }
        )
    }

    private fun doubleClick(teste: ConstraintLayout) {
        teste.isEnabled = false
        Handler().postDelayed({
            teste.isEnabled = true
        }, 1000)
    }

    private fun startFragmentSelectedDatePeriodBottomSheet() {
        val bottomSheetDialog =
            SelectedDatePeriodBottomSheet.newInstance()
        bottomSheetDialog.show(
            requireActivity().supportFragmentManager,
            SelectedDatePeriodBottomSheet.FRAGMENT_TAG
        )
    }

    private fun startFragmentSelectedMovementBottomSheet() {
        val bottomSheetDialog =
            SelectedMovementBottomSheet.newInstance()
        bottomSheetDialog.show(
            requireActivity().supportFragmentManager,
            SelectedMovementBottomSheet.FRAGMENT_TAG
        )
    }
    private fun navigateToCalendar() {
        val directions = HomeFragmentDirections.toCalendar()
        view?.findNavController()?.navigate(directions)
    }
}
