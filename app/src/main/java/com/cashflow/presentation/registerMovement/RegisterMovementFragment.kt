package com.cashflow.com.cashflow.presentation.registerMovement

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.cashflow.com.cashflow.presentation.utils.styles.setStatusBarDarkMode
import com.cashflow.databinding.FragmentRegisterMovementBinding
import dagger.hilt.android.AndroidEntryPoint

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
        setUpClick()
    }

    private fun setUpClick() {
        binding.back.setOnClickListener {
            view?.findNavController()?.popBackStack()
        }
    }

}
