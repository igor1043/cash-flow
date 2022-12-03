package com.cashflow.room.mvvm.home.mock

import com.cashflow.room.mvvm.home.modelview.SpendingCategoryUiModel

fun listItens(): MutableList<SpendingCategoryUiModel> {
    val list: MutableList<SpendingCategoryUiModel> = mutableListOf()
    list.add(createItem("Alimentação",100.20,200.00))
    list.add(createItem("Transporte",25.20,300.00))
    list.add(createItem("Luz",92.58,100.00))
    list.add(createItem("Água",25.20,80.00))
    list.add(createItem("Internet",100.00,100.00))
    return list
}

fun createItem(name: String, value: Double, valueTotal: Double): SpendingCategoryUiModel {
    return SpendingCategoryUiModel(
        name,
        value,
        valueTotal
    )
}
abstract class MockSpendingCategory {

    companion object {
        @JvmStatic
        fun createListItens(): MutableList<SpendingCategoryUiModel> {
            return listItens()
        }
    }
}