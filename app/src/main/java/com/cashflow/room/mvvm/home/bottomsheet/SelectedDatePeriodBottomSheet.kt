package com.cashflow.room.mvvm.home.bottomsheet

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
import com.cashflow.room.mvvm.home.HomeViewModel
import com.cashflow.room.mvvm.utils.Event
import com.example.room.mvvm.R
import com.example.room.mvvm.databinding.FragmentSelectDatePeriodBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_select_date_period.*


class SelectedDatePeriodBottomSheet : BottomSheetDialogFragment() {
    private val TAG = SelectedDatePeriodBottomSheet::class.java.simpleName
    private lateinit var binding: FragmentSelectDatePeriodBinding
    private lateinit var mBehavior: BottomSheetBehavior<View>

    private val homeViewModel: HomeViewModel by activityViewModels ()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val inflater = LayoutInflater.from(requireContext())
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_select_date_period,
            bottom_sheet_select_date,
            false
        )
        binding.lifecycleOwner = this
        val dialog: BottomSheetDialog =
            super.onCreateDialog(savedInstanceState) as BottomSheetDialog
        val view = binding.root
        dialog.setContentView(view)
        mBehavior = BottomSheetBehavior.from(view.parent as View)
        val bottomSheet = view.parent as View
        bottomSheet.backgroundTintMode = PorterDuff.Mode.CLEAR
        bottomSheet.backgroundTintList = ColorStateList.valueOf(Color.TRANSPARENT)
        bottomSheet.setBackgroundColor(Color.TRANSPARENT)

        binding.buttomSelectPeriod.setOnClickListener {
            homeViewModel._successSendPoints.value = Event(true)
        }

        return dialog

    }


    override fun onResume() {
        super.onResume()
        mBehavior.state = BottomSheetBehavior.STATE_EXPANDED
    }

    companion object {
        /**
         * Argumento para ser passado para o fragment
         */
        const val FRAGMENT_TAG = "bottomSheetFragmentMaterialTag"
        private const val ARG_SERVICE_ORDER_ID = "serviceOrderId"
        private const val ARG_ACCOUNT_ID = "accountId"
        private const val ARG_GEO_ID = "geoId"

        fun newInstance(
        ): SelectedDatePeriodBottomSheet {
            return SelectedDatePeriodBottomSheet().apply { }
        }
    }
}