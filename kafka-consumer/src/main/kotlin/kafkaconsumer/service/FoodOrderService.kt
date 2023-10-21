package kafkaconsumer.service

import kafkaconsumer.FoodOrderRepository
import kafkaconsumer.model.FoodOrder
import mu.KotlinLogging
import org.springframework.stereotype.Service

private val log = KotlinLogging.logger {}

@Service
class FoodOrderService(
    val repository: FoodOrderRepository,
) {
    fun persistFoodOrder(order: FoodOrder) {
        repository.save(order)
        log.info { "Order: $order saved to db." }
    }
}
