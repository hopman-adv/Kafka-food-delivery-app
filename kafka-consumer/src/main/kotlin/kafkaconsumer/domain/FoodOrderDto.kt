package kafkaconsumer.domain

import kafkaconsumer.model.FoodOrder

data class FoodOrderDto(val item: String, val amount: Double)

fun FoodOrderDto.toFoodOrder() =
    FoodOrder(
        null,
        this.item,
        this.amount
    )
