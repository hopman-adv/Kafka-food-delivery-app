package kafkaconsumer.consumer

import kafkaconsumer.domain.FoodOrderDto
import kafkaconsumer.domain.toFoodOrder
import kafkaconsumer.service.FoodOrderService
import kafkaconsumer.utils.Constants
import mu.KotlinLogging
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

private val log = KotlinLogging.logger {}

@Component
class Consumer(
    val service: FoodOrderService,
) {
    @KafkaListener(topics = [Constants.FOOD_ORDER_TOPIC_NAME])
    fun consumeOrder(order: FoodOrderDto) {
        log.info("message consumed {}", order);
        service.persistFoodOrder(order.toFoodOrder())
    }
}