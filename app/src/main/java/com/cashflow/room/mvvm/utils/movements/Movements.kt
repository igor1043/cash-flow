package com.cashflow.room.mvvm.utils.movements

import com.cashflow.room.mvvm.R

class Movements

data class TypeFilter(val typeName: String, val name: String)

fun getTypeMovements(): List<TypesMovements> {
    val list = mutableListOf<TypesMovements>()
    TypesMovements.values().forEach {
        list.add(it)
    }
    list.sortBy { it.name }
    return list
}

enum class TypesMovements(
    val id: Int,
    val movement: String,
    val nameMovement: String,
    val color: Int,
    val icon: Int
) {
    TRANSFER(1, "transfer", "Transferência", R.color.yellow_500, R.drawable.ic_movement_transfer),
    REVENUE(2, "revenue", "Receita", R.color.green_500, R.drawable.ic_movement_revenue),
    EXPENSE(3, "expense", "Despesa", R.color.red_500, R.drawable.ic_movement_expense),
    EXPENSE_CARD(4, "expense card", "Despesa Cartão", R.color.blue_500, R.drawable.ic_movement_expense_card);
}

enum class GroupCategories(
    val id: Int,
    val typeMovement: TypesMovements,
    val category: String,
    val nameCategory: String
) {
    OTHERS(1, TypesMovements.REVENUE, "others", "Outros"),
    BENEFITS(2, TypesMovements.REVENUE, "benefits", "Benefícios"),
    COMMISSION(3, TypesMovements.REVENUE, "commission", "Comissão"),
    FIXED(4, TypesMovements.REVENUE, "fixed", "Fixa"),
    PAYMENTS(5, TypesMovements.REVENUE, "payments", "Pagamentos"),
    INCOME(6, TypesMovements.REVENUE, "income", "Redimentos"),
    SERVICES(7, TypesMovements.REVENUE, "services", "Serviços"),
    SALES(8, TypesMovements.REVENUE, "sales", "Vendas");
}

enum class SubGroupCategories(
    val id: Int,
    val groupCategories: GroupCategories,
    val subCategory: String,
    val nameSubCategory: String
) {
    OTHERS(1, GroupCategories.OTHERS, "others", "Outros"),
    OTHERS_BENEFITS(2, GroupCategories.BENEFITS, "others", "Outros"),
    FOOD(3, GroupCategories.BENEFITS, "food", "Alimentação"),
    SNACK(4, GroupCategories.BENEFITS, "snack", "Refeição"),
    TRANSPORT(5, GroupCategories.BENEFITS, "transport", "Transporte"),
    OTHERS_COMMISSION(6, GroupCategories.COMMISSION, "others", "Outros"),
    OTHERS_FIXED(7, GroupCategories.FIXED, "others", "Outros"),
    WAGE(8, GroupCategories.FIXED, "wage", "Salário"),
    OTHERS_PAYMENTS(9, GroupCategories.PAYMENTS, "others", "Outros"),
    LOANS(10, GroupCategories.PAYMENTS, "loans", "Empréstimos"),
    OTHERS_INCOME(11, GroupCategories.INCOME, "others", "Outros"),
    OTHERS_SERVICES(12, GroupCategories.SERVICES, "others", "Outros"),
    OTHERS_SALES(12, GroupCategories.SALES, "others", "Outros");
}
