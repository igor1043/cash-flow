package com.cashflow.com.cashflow.presentation.home.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cashflow.R
import com.cashflow.com.cashflow.domain.model.IdQuickAccess
import com.cashflow.com.cashflow.domain.model.QuickAccessModel
import com.cashflow.databinding.ItemQuickAccessMenuBinding


class QuickAccessAdapter :
    ListAdapter<QuickAccessModel, QuickAccessAdapter.ViewHolder>(DIFF_CALLBACK) {

    private val positionItem = MutableLiveData<Int>()
    var onClick :(buttonClickId: IdQuickAccess) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_quick_access_menu,
                parent,
                false,
            ),
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
        positionItem.value = position
    }

    inner class ViewHolder(
        val binding: ItemQuickAccessMenuBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n", "ResourceAsColor")
        fun bind(movementUiModel: QuickAccessModel) {
            with(binding) {
                buttonImage.setImageResource(movementUiModel.icon)
                buttonText.text = movementUiModel.name

                executePendingBindings()
            }
            binding.item.setOnClickListener {
                onClick(movementUiModel.id)
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<QuickAccessModel>() {
            override fun areItemsTheSame(
                oldItem: QuickAccessModel,
                newItem: QuickAccessModel,
            ): Boolean = oldItem == newItem

            override fun areContentsTheSame(
                oldItem: QuickAccessModel,
                newItem: QuickAccessModel,
            ): Boolean = oldItem == newItem
        }
    }
}
