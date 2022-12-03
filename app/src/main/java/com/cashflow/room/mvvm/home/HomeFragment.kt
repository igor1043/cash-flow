package com.cashflow.room.mvvm.home


import android.os.Build
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import com.cashflow.room.mvvm.home.adapter.MovementsAdapter
import com.cashflow.room.mvvm.home.adapter.SpendingByCategoryAdapter
import com.cashflow.room.mvvm.home.bottomsheet.SelectedDatePeriodBottomSheet
import com.cashflow.room.mvvm.home.mock.MockMovements
import com.cashflow.room.mvvm.home.mock.MockSpendingCategory
import com.cashflow.room.mvvm.utils.styles.setStatusBarDarkMode
import com.example.room.mvvm.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var spendingByCategoryAdapter: SpendingByCategoryAdapter
    private lateinit var movementsAdapter: MovementsAdapter

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        setStatusBarDarkMode(true)

        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        spendingByCategoryAdapter = SpendingByCategoryAdapter()
        spendingByCategoryAdapter.submitList(MockSpendingCategory.createListItens())
        binding.spendingCategory.recycleView.adapter = spendingByCategoryAdapter


        movementsAdapter = MovementsAdapter()
        movementsAdapter.submitList(MockMovements.createListMovements())
        binding.moviments.recycleView.adapter = movementsAdapter

        binding.principalCard.bottomDatePeriod.setOnClickListener {
            startFragmentSelectedDatePeriodBottomSheet()
            binding.principalCard.bottomDatePeriod.isEnabled = false
            Handler().postDelayed({
                binding.principalCard.bottomDatePeriod.isEnabled = true
            },1000)
        }
        super.onViewCreated(view, savedInstanceState)
    }

    private fun startFragmentSelectedDatePeriodBottomSheet() {
        val bottomSheetDialog =
            SelectedDatePeriodBottomSheet.newInstance()
        bottomSheetDialog.show(
            requireActivity().supportFragmentManager,
            SelectedDatePeriodBottomSheet.FRAGMENT_TAG
        )
    }


}
