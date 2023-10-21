package Kafkaproducer.service

import Kafkaproducer.dao.FoodOrderDto
import com.fasterxml.jackson.core.JsonProcessingException
import org.springframework.stereotype.Service


@Service
class FoodOrderService(val producer: Producer) {
    @Throws(JsonProcessingException::class)
    fun createFoodOrder(foodOrder: FoodOrderDto): String {
        return producer.sendMessage(foodOrder)
    }

}
