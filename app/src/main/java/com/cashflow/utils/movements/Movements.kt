package com.cashflow.utils.movements

import com.cashflow.R

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
    EXPENSE_CARD(
        4,
        "expense card",
        "Despesa Cartão",
        R.color.blue_500,
        R.drawable.ic_movement_expense_card
    );
}

enum class MovementsCategories(
    val id: Int,
    val icon: Int,
    val typeMovement: TypesMovements,
    val category: GroupCategories,
    val nameCategory: String
) {
    OTHERS(
        1,
        R.drawable.ic_movement_wage,
        TypesMovements.REVENUE,
        GroupCategories.REVENUES,
        "Outros"
    ),
    BENEFITS(
        2,
        R.drawable.ic_movement_wage,
        TypesMovements.REVENUE,
        GroupCategories.REVENUES,
        "Benefícios"
    ),
    COMMISSION(
        3,
        R.drawable.ic_movement_wage,
        TypesMovements.REVENUE,
        GroupCategories.REVENUES,
        "Comissão"
    ),
    FIXED(4, R.drawable.ic_movement_wage, TypesMovements.REVENUE, GroupCategories.REVENUES, "Fixa"),
    PAYMENTS(
        5,
        R.drawable.ic_movement_wage,
        TypesMovements.REVENUE,
        GroupCategories.REVENUES,
        "Pagamentos"
    ),
    INCOME(
        6,
        R.drawable.ic_movement_wage,
        TypesMovements.REVENUE,
        GroupCategories.REVENUES,
        "Redimentos"
    ),
    SERVICES(
        7,
        R.drawable.ic_movement_wage,
        TypesMovements.REVENUE,
        GroupCategories.REVENUES,
        "Serviços"
    ),
    SALES(
        8,
        R.drawable.ic_movement_wage,
        TypesMovements.REVENUE,
        GroupCategories.REVENUES,
        "Vendas"
    ),
    WAGE(
        8,
        R.drawable.ic_movement_wage,
        TypesMovements.REVENUE,
        GroupCategories.REVENUES,
        "Salário"
    ),

    // Categories for TypesMovements.TRANSFER
    TRANSFER_TO_SAVINGS(
        47,
        R.drawable.ic_movement_wage,
        TypesMovements.TRANSFER,
        GroupCategories.OTHERS,
        "Transferência para Poupança"
    ),
    TRANSFER_TO_INVESTMENTS(
        48,
        R.drawable.ic_movement_wage,
        TypesMovements.TRANSFER,
        GroupCategories.OTHERS,
        "Transferência para Investimentos"
    ),
    TRANSFER_TO_EMERGENCY(
        51,
        R.drawable.ic_movement_wage,
        TypesMovements.TRANSFER,
        GroupCategories.OTHERS,
        "Transferência para Emergência"
    ),
    TRANSFER_TO_RENT(
        52,
        R.drawable.ic_movement_wage,
        TypesMovements.TRANSFER,
        GroupCategories.OTHERS,
        "Transferência para Aluguel"
    ),
    TRANSFER_TO_LOAN(
        53,
        R.drawable.ic_movement_wage,
        TypesMovements.TRANSFER,
        GroupCategories.OTHERS,
        "Transferência para Empréstimo"
    ),
    TRANSFER_TO_VACATION(
        54,
        R.drawable.ic_movement_wage,
        TypesMovements.TRANSFER,
        GroupCategories.OTHERS,
        "Transferência para Férias"
    ),
    TRANSFER_TO_HEALTH(
        55,
        R.drawable.ic_movement_wage,
        TypesMovements.TRANSFER,
        GroupCategories.OTHERS,
        "Transferência para Saúde"
    ),
    TRANSFER_TO_EDUCATION(
        56,
        R.drawable.ic_movement_wage,
        TypesMovements.TRANSFER,
        GroupCategories.OTHERS,
        "Transferência para Educação"
    ),
    TRANSFER_TO_CHARITY(
        57,
        R.drawable.ic_movement_wage,
        TypesMovements.TRANSFER,
        GroupCategories.OTHERS,
        "Transferência para Caridade"
    ),
    TRANSFER_TO_WEDDING(
        58,
        R.drawable.ic_movement_wage,
        TypesMovements.TRANSFER,
        GroupCategories.OTHERS,
        "Transferência para Casamento"
    ),
    TRANSFER_TO_TAXES(
        59,
        R.drawable.ic_movement_wage,
        TypesMovements.TRANSFER,
        GroupCategories.OTHERS,
        "Transferência para Impostos"
    ),
    TRANSFER_TO_INSURANCE(
        60,
        R.drawable.ic_movement_wage,
        TypesMovements.TRANSFER,
        GroupCategories.OTHERS,
        "Transferência para Seguros"
    ),
    TRANSFER_TO_CREDIT_CARD(
        61,
        R.drawable.ic_movement_wage,
        TypesMovements.TRANSFER,
        GroupCategories.OTHERS,
        "Transferência para Cartão de Crédito"
    ),

    // Categories for TypesMovements.EXPENSE
    CLOTHING(
        62,
        R.drawable.ic_movement_wage,
        TypesMovements.EXPENSE,
        GroupCategories.OTHERS,
        "Roupas"
    ),
    ELECTRONICS(
        63,
        R.drawable.ic_movement_wage,
        TypesMovements.EXPENSE,
        GroupCategories.ENTERTAIMENT,
        "Eletrônicos"
    ),
    HOBBIES(
        64,
        R.drawable.ic_movement_wage,
        TypesMovements.EXPENSE,
        GroupCategories.ENTERTAIMENT,
        "Hobbies"
    ),
    BEAUTY(
        65,
        R.drawable.ic_movement_wage,
        TypesMovements.EXPENSE,
        GroupCategories.OTHERS,
        "Beleza"
    ),
    TRAVEL(
        66,
        R.drawable.ic_movement_wage,
        TypesMovements.EXPENSE,
        GroupCategories.OTHERS,
        "Viagens"
    ),
    SUBSCRIPTIONS(
        67,
        R.drawable.ic_movement_wage,
        TypesMovements.EXPENSE,
        GroupCategories.OTHERS,
        "Assinaturas"
    ),
    GIFTS(
        68,
        R.drawable.ic_movement_wage,
        TypesMovements.EXPENSE,
        GroupCategories.OTHERS,
        "Presentes"
    ),
    PETS(
        69,
        R.drawable.ic_movement_wage,
        TypesMovements.EXPENSE,
        GroupCategories.MEDICAL_EXPENSES_PETS,
        "Despesas com Animais de Estimação"
    ),
    HOME_REPAIR(
        70,
        R.drawable.ic_movement_home_repair,
        TypesMovements.EXPENSE,
        GroupCategories.OTHERS,
        "Reparos em Casa"
    ),
    FITNESS(
        71,
        R.drawable.ic_movement_wage,
        TypesMovements.EXPENSE,
        GroupCategories.OTHERS,
        "Despesas com Fitness"
    ),
    MEDICAL_EXPENSES(
        72,
        R.drawable.ic_movement_wage,
        TypesMovements.EXPENSE,
        GroupCategories.MEDICAL_EXPENSE,
        "Despesas Médicas"
    ),
    EDUCATIONAL_EXPENSES(
        73,
        R.drawable.ic_movement_wage,
        TypesMovements.EXPENSE,
        GroupCategories.OTHERS,
        "Despesas Educacionais"
    ),
    DONATIONS(
        74,
        R.drawable.ic_movement_wage,
        TypesMovements.EXPENSE,
        GroupCategories.OTHERS,
        "Doações"
    ),
    CAR_EXPENSES(
        75,
        R.drawable.ic_movement_wage,
        TypesMovements.EXPENSE,
        GroupCategories.OTHERS,
        "Despesas com Carro"
    ),
    TECHNOLOGY(
        76,
        R.drawable.ic_movement_wage,
        TypesMovements.EXPENSE,
        GroupCategories.ENTERTAIMENT,
        "Tecnologia"
    ),

    // Categories for TypesMovements.EXPENSE_CARD
    ONLINE_SERVICES(
        77,
        R.drawable.ic_movement_wage,
        TypesMovements.EXPENSE_CARD,
        GroupCategories.OTHERS,
        "Serviços Online"
    ),
    ELECTRIC_BILLS(
        78,
        R.drawable.ic_movement_electric_bolt,
        TypesMovements.EXPENSE_CARD,
        GroupCategories.OTHERS,
        "Contas de Luz"
    ),
    PHONE_BILLS(
        79,
        R.drawable.ic_movement_wage,
        TypesMovements.EXPENSE_CARD,
        GroupCategories.OTHERS,
        "Contas de Telefone"
    ),
    BOOKS(
        80,
        R.drawable.ic_movement_wage,
        TypesMovements.EXPENSE_CARD,
        GroupCategories.ENTERTAIMENT,
        "Livros"
    ),
    SPORTS(
        81,
        R.drawable.ic_movement_wage,
        TypesMovements.EXPENSE_CARD,
        GroupCategories.ENTERTAIMENT,
        "Despesas com Esportes"
    ),
    MUSIC(
        82,
        R.drawable.ic_movement_wage,
        TypesMovements.EXPENSE_CARD,
        GroupCategories.ENTERTAIMENT,
        "Música"
    ),
    MOVIES(
        83,
        R.drawable.ic_movement_wage,
        TypesMovements.EXPENSE_CARD,
        GroupCategories.ENTERTAIMENT,
        "Cinema"
    ),
    GAMING(
        84,
        R.drawable.ic_movement_game,
        TypesMovements.EXPENSE_CARD,
        GroupCategories.ENTERTAIMENT,
        "Jogos"
    ),
    CAR_MAINTENANCE(
        85,
        R.drawable.ic_movement_wage,
        TypesMovements.EXPENSE_CARD,
        GroupCategories.OTHERS,
        "Manutenção do Carro"
    ),
    TAXES(
        86,
        R.drawable.ic_movement_wage,
        TypesMovements.EXPENSE_CARD,
        GroupCategories.OTHERS,
        "Impostos"
    ),
    VACATION_EXPENSES(
        87,
        R.drawable.ic_movement_wage,
        TypesMovements.EXPENSE_CARD,
        GroupCategories.OTHERS,
        "Despesas de Férias"
    ),
    HOME_DECOR(
        88,
        R.drawable.ic_movement_wage,
        TypesMovements.EXPENSE_CARD,
        GroupCategories.OTHERS,
        "Decoração de Casa"
    ),
    WEDDING_EXPENSES(
        89,
        R.drawable.ic_movement_wage,
        TypesMovements.EXPENSE_CARD,
        GroupCategories.OTHERS,
        "Despesas de Casamento"
    ),
    GIFT_CARDS(
        90,
        R.drawable.ic_movement_wage,
        TypesMovements.EXPENSE_CARD,
        GroupCategories.OTHERS,
        "Cartões Presente"
    ),
    VEHICLE_INSURANCE(
        91,
        R.drawable.ic_movement_wage,
        TypesMovements.EXPENSE,
        GroupCategories.TRANSPORT,
        "Seguro do veículo"
    ),
    EXPENSE_TRAVEL(
        92,
        R.drawable.ic_movement_wage,
        TypesMovements.EXPENSE,
        GroupCategories.TRAVEL,
        "Gastos com Viagem"
    );
}

enum class GroupCategories(
    val id: Int,
    val group: String,
) {
    ENTERTAIMENT(1, "Entreterimento"),
    MEDICAL_EXPENSE(2, "Despesas Médicas"),
    MEDICAL_EXPENSES_PETS(3, "Despesas Com pets"),
    TRANSPORT(4, "Transportes"),
    REVENUES(5, "Receitas"),
    TRAVEL(6, "Viagem"),
    OTHERS(7, "Outros"),
}

enum class StatusMovement(
    val id: Int,
    val status: String,
) {
    RECEIVED(1, "Recebido"),
    PAID(2, "Pago"),
    PAYABLE(3, "A Pagar");
}

