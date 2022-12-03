/*
 * SipuB - Sistema de Informação Pública
 * @link https://github.com/facilitatech/sipub-cad for the canonical source repository
 * @copyright Copyright (c) Facilita.tech. (https://facilita.tech)
 */

package com.cashflow.room.mvvm.home.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cashflow.room.mvvm.home.modelview.SpendingCategoryUiModel
import com.example.room.mvvm.R
import com.example.room.mvvm.databinding.ItemSpendingCategoryBinding
import kotlinx.android.synthetic.main.item_spending_category.view.*
import kotlin.math.round

class SpendingByCategoryAdapter() :
    ListAdapter<SpendingCategoryUiModel, SpendingByCategoryAdapter.ViewHolder>(DIFF_CALLBACK) {

    private val positionItem = MutableLiveData<Int>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_spending_category, parent, false
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

        @SuppressLint("SetTextI18n")
        fun bind(spendingCategory: SpendingCategoryUiModel) {
            with(binding) {
                this.nameSpending.text = spendingCategory.name
                this.valueSpending.text = "R$${spendingCategory.value}"
                val percentage = (spendingCategory.value / spendingCategory.valueTotal) * 100
                this.percetageSpending.text = "(${round(percentage)}%)"
                this.valueTotal.text = "R$${spendingCategory.valueTotal}"
                this.progressBar.max = spendingCategory.valueTotal.toInt()
                this.progressBar.progress = spendingCategory.value.toInt()
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