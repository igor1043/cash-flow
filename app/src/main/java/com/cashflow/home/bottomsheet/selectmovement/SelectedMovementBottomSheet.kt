package com.cashflow.home.bottomsheet.selectmovement

import android.app.Dialog
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.cashflow.home.HomeViewModel
import com.cashflow.home.bottomsheet.selectmovement.adapter.TypeMovementsAdapter
import com.cashflow.utils.movements.getTypeMovements
import com.cashflow.R
import com.cashflow.databinding.FragmentSelectMovementBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class SelectedMovementBottomSheet : BottomSheetDialogFragment() {
    private val TAG = SelectedMovementBottomSheet::class.java.simpleName
    private lateinit var binding: FragmentSelectMovementBinding
    private lateinit var mBehavior: BottomSheetBehavior<View>
    private lateinit var movementsAdapter: TypeMovementsAdapter

    private val homeViewModel: HomeViewModel by activityViewModels()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val inflater = LayoutInflater.from(requireContext())
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_select_movement,
            view?.findViewById(R.id.bottom_sheet_select_date),
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

        movementsAdapter = TypeMovementsAdapter(requireContext())
        movementsAdapter.submitList(getTypeMovements())
        binding.typeMovementsRecycleView.adapter = movementsAdapter

        setupObservers()
        setupClick()
        return dialog
    }

    private fun setupObservers() {
    }

    private fun setupClick() {
    }

    override fun onResume() {
        super.onResume()
        mBehavior.state = BottomSheetBehavior.STATE_EXPANDED
    }

    companion object {
        const val FRAGMENT_TAG = "bottomSheetFragmentMovementTag"
        fun newInstance(): SelectedMovementBottomSheet {
            return SelectedMovementBottomSheet().apply { }
        }
    }
}
