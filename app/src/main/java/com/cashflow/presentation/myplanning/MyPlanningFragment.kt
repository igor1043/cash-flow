package com.cashflow.com.cashflow.presentation.myplanning

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.cashflow.com.cashflow.presentation.utils.styles.setStatusBarDarkMode
import com.cashflow.databinding.FragmentMyFinancesBinding
import com.cashflow.databinding.FragmentMyPlanningBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyPlanningFragment : Fragment() {

    private lateinit var binding: FragmentMyPlanningBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        setStatusBarDarkMode(true)

        binding = FragmentMyPlanningBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpClick()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun setUpClick() {
        binding.back.setOnClickListener {
            view?.findNavController()?.popBackStack()
        }
    }
}
