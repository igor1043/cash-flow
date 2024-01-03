package com.cashflow.com.cashflow.presentation.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.cashflow.R
import com.cashflow.com.cashflow.presentation.registerMovement.RegisterMovementViewModel
import com.cashflow.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    lateinit var navController: NavController
    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        loginViewModel.createUser()
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        activity?.window?.statusBarColor = ContextCompat.getColor(requireContext(), R.color.colorPrimary)
        activity?.window?.navigationBarColor = ContextCompat.getColor(requireContext(), R.color.colorPrimary)

        binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        binding.loginButton.setOnClickListener {
            navController.navigate(R.id.action_login_to_home)
        }
    }
}
