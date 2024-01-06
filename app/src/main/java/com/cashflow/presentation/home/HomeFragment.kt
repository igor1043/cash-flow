package com.cashflow.com.cashflow.presentation.home

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
import com.cashflow.com.cashflow.domain.model.ExpenseModel
import com.cashflow.databinding.FragmentHomeBinding
import com.cashflow.com.cashflow.presentation.home.adapter.MovementsAdapter
import com.cashflow.com.cashflow.presentation.home.adapter.SpendingByCategoryAdapter
import com.cashflow.com.cashflow.presentation.home.bottomsheet.selectdateperiod.SelectedDatePeriodBottomSheet
import com.cashflow.com.cashflow.presentation.home.bottomsheet.selectmovement.SelectedMovementBottomSheet
import com.cashflow.com.cashflow.presentation.home.mock.MockSpendingCategory
import com.cashflow.com.cashflow.presentation.utils.EventObserver
import com.cashflow.com.cashflow.presentation.utils.date.getCurrentMonth
import com.cashflow.com.cashflow.presentation.utils.date.getCurrentYear
import com.cashflow.com.cashflow.presentation.utils.styles.setStatusBarDarkMode
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var spendingByCategoryAdapter: SpendingByCategoryAdapter
    private lateinit var movementsAdapter: MovementsAdapter

    private val homeViewModel: HomeViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        homeViewModel.getUser()
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
        homeViewModel.getMockLastMovements()
        spendingByCategoryAdapter = SpendingByCategoryAdapter()
        spendingByCategoryAdapter.submitList(MockSpendingCategory.createListItens(requireContext()))
        binding.spendingCategory.recycleView.adapter = spendingByCategoryAdapter
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
        homeViewModel.user.observe(
            viewLifecycleOwner,
            EventObserver {
                binding.userName.text = it.name
            }
        )
        homeViewModel.currentMonth.observe(
            viewLifecycleOwner,
            EventObserver {
                binding.principalCard.mouth.text = it.brazilianName
            }
        )
        homeViewModel.lastMovements.observe(
            viewLifecycleOwner,
            EventObserver {
                configureAdapterLastMovements(it)
            }
        )
    }

    private fun configureAdapterLastMovements(movementModels: List<ExpenseModel>) {
        movementsAdapter = MovementsAdapter()
        movementsAdapter.submitList(movementModels)
        binding.moviments.recycleView.adapter = movementsAdapter

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
        val bottomSheetDialog = SelectedMovementBottomSheet {
            navigateToRegisterMovement()
        }
        bottomSheetDialog.show(
            requireActivity().supportFragmentManager,
            SelectedMovementBottomSheet.FRAGMENT_TAG
        )
    }

    private fun navigateToCalendar() {
        val directions = HomeFragmentDirections.toCalendar()
        view?.findNavController()?.navigate(directions)
    }

    private fun navigateToRegisterMovement() {
        val directions = HomeFragmentDirections.toRegisterMovement()
        view?.findNavController()?.navigate(directions)
    }
}
