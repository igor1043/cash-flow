package com.cashflow.home.mock

import android.annotation.SuppressLint
import android.content.Context
import com.cashflow.home.modelview.SpendingCategoryUiModel
import com.cashflow.R

@SuppressLint("ResourceType")
fun listItens(context: Context): MutableList<SpendingCategoryUiModel> {
    val list: MutableList<SpendingCategoryUiModel> = mutableListOf()
    list.add(createItem("Alimentação", 1000.20, 200.00, R.drawable.ic_chevron_left,context.resources.getString(R.color.red_10)))
    list.add(createItem("Transporte", 25.20, 300.00, R.drawable.ic_chevron_left,context.resources.getString(R.color.sb_purple)))
    list.add(createItem("Luz", 92.58, 100.00, R.drawable.ic_chevron_left,context.resources.getString(R.color.danger_10)))
    list.add(createItem("Água", 25.20, 80.00, R.drawable.ic_chevron_left,context.resources.getString(R.color.neutral_500)))
    list.add(createItem("Internet", 100.00, 100.00, R.drawable.ic_chevron_left,context.resources.getString(R.color.red_10)))
    return list
}

fun createItem(
    name: String,
    value: Double,
    valueTotal: Double,
    iconSpending: Int,
    colorSpending: String
): SpendingCategoryUiModel {
    return SpendingCategoryUiModel(
        name,
        value,
        valueTotal,
        iconSpending,
        colorSpending
    )
}

abstract class MockSpendingCategory {

    companion object {
        @JvmStatic
        fun createListItens(context: Context): MutableList<SpendingCategoryUiModel> {
            return listItens(context)
        }
    }
}