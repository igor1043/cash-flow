package com.cashflow.com.cashflow.presentation.home.adapter

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cashflow.com.cashflow.presentation.home.modelview.SpendingCategoryUiModel
import com.cashflow.com.cashflow.presentation.utils.number.decimalValue
import com.cashflow.R
import com.cashflow.databinding.ItemSpendingCategoryBinding
import kotlin.math.round

class SpendingByCategoryAdapter() :
    ListAdapter<SpendingCategoryUiModel, SpendingByCategoryAdapter.ViewHolder>(DIFF_CALLBACK) {

    private val positionItem = MutableLiveData<Int>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_spending_category,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
        positionItem.value = position
    }

    inner class ViewHolder(
        val binding: ItemSpendingCategoryBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n", "ResourceAsColor", "Range")
        fun bind(spendingCategory: SpendingCategoryUiModel) {
            with(binding) {
                this.nameSpending.text = spendingCategory.name
                this.valueSpending.text = "R$${decimalValue(spendingCategory.value)}"
                val percentage = (spendingCategory.value / spendingCategory.valueTotal) * 100
                this.percetageSpending.text = "${round(percentage)}%"
                this.valueTotal.text = "R$${decimalValue(spendingCategory.valueTotal)}"
                this.progressBar.max = spendingCategory.valueTotal.toInt()
                this.progressBar.progress = spendingCategory.value.toInt()
                this.iconSpending.setBackgroundResource(spendingCategory.iconSpending)
                this.progressBar.progressTintList =
                    ColorStateList.valueOf(Color.parseColor(spendingCategory.colorSpending))
                this.sumLeft.text = "${decimalValue(spendingCategory.valueTotal - spendingCategory.value)}"

                executePendingBindings()
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<SpendingCategoryUiModel>() {
            override fun areItemsTheSame(
                oldItem: SpendingCategoryUiModel,
                newItem: SpendingCategoryUiModel
            ): Boolean = oldItem == newItem

            override fun areContentsTheSame(
                oldItem: SpendingCategoryUiModel,
                newItem: SpendingCategoryUiModel
            ): Boolean = oldItem == newItem
        }
    }
}
