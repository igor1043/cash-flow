package com.cashflow.com.cashflow.presentation.myexpenses

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.cashflow.com.cashflow.domain.model.ExpenseModel
import com.cashflow.com.cashflow.domain.model.RevenueModel
import com.cashflow.com.cashflow.presentation.calendar.MyFinancesViewModel
import com.cashflow.com.cashflow.presentation.home.adapter.MovementRevenueAdapter
import com.cashflow.com.cashflow.presentation.home.adapter.MovementsAdapter
import com.cashflow.com.cashflow.presentation.utils.EventObserver
import com.cashflow.com.cashflow.presentation.utils.styles.setStatusBarDarkMode
import com.cashflow.databinding.FragmentMyFinancesBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.Calendar

@AndroidEntryPoint
class MyFinancesFragment : Fragment() {

    private lateinit var binding: FragmentMyFinancesBinding
    private val viewModel: MyFinancesViewModel by viewModels()
    private lateinit var movementsAdapter: MovementsAdapter
    private lateinit var movementsRevenueAdapter: MovementRevenueAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        setStatusBarDarkMode(true)

        binding = FragmentMyFinancesBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this


        binding.calendar.setOnDateChangeListener { view, year, month, dayOfMonth ->
            viewModel.getExpensesByDate(year, month + 1, dayOfMonth)
        }
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        getDate()
        setupObservers()
        setUpClick()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun setupObservers() {
        viewModel.listExpenses.observe(
            viewLifecycleOwner,
            EventObserver {
                configureAdapterExpenses(it)
            }
        )
        viewModel.listRevenues.observe(
            viewLifecycleOwner,
            EventObserver {
                configureAdapterRevenues(it)
            }
        )
    }

    private fun setUpClick() {
        binding.back.setOnClickListener {
            view?.findNavController()?.popBackStack()
        }
    }

    private fun configureAdapterExpenses(movementModels: List<ExpenseModel>) {
        movementsAdapter = MovementsAdapter()
        movementsAdapter.submitList(movementModels)
        binding.recycleView.adapter = movementsAdapter
    }

    private fun configureAdapterRevenues(movementModels: List<RevenueModel>) {
        movementsRevenueAdapter = MovementRevenueAdapter()
        movementsRevenueAdapter.submitList(movementModels)
        binding.recycleViewRevenues.adapter = movementsRevenueAdapter
    }

    private fun getDate() {
        val currentCalendar = Calendar.getInstance()
        val year = currentCalendar.get(Calendar.YEAR)
        val month = currentCalendar.get(Calendar.MONTH) + 1
        val dayOfMonth = currentCalendar.get(Calendar.DAY_OF_MONTH)
        viewModel.getExpensesByDate(year, month, dayOfMonth)
        viewModel.getRevenuesByDate(year, month, dayOfMonth)
    }
}
