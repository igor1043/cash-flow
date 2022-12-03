package com.cashflow.room.mvvm.home.mock

import com.cashflow.room.mvvm.home.modelview.MovementUiModel


fun listMovements(): MutableList<MovementUiModel> {
    val list: MutableList<MovementUiModel> = mutableListOf()
    list.add(createItemMovement("recebimento","salario","entrada", 100.20, "08:30 10/06","recebido"))
    list.add(createItemMovement("passagem","Transporte","saida" ,25.20, "08:30 10/06","pago"))
    list.add(createItemMovement("pagamento de conta","Luz","saida", 92.58, "08:30 10/06","pago"))
    list.add(createItemMovement("pagamento de conta","Água", "saida",25.20, "08:30 10/06","a pagar"))
    list.add(createItemMovement("pagamento de conta","Internet", "saida",100.00, "08:30 10/06","a pagar"))
    return list
}

fun createItemMovement(
    name: String,
    typeMovement: String,
    movement: String,
    value: Double,
    date: String,
    status: String,
): MovementUiModel {
    return MovementUiModel(
        name,
        typeMovement,
        movement,
        value,
        date,
        status,
    )
}

abstract class MockMovements {

    companion object {
        @JvmStatic
        fun createListMovements(): MutableList<MovementUiModel> {
            return listMovements()
        }
    }
}