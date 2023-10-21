package Kafkaproducer.controller

import Kafkaproducer.dao.FoodOrderDto
import Kafkaproducer.service.FoodOrderService
import com.fasterxml.jackson.core.JsonProcessingException
import mu.KotlinLogging
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

private val log = KotlinLogging.logger {}

@RestController
@RequestMapping("/order")
class FoodOrderController(val foodOrderService: FoodOrderService) {
    @PostMapping
    @Throws(JsonProcessingException::class)
    fun createFoodOrder(@RequestBody foodOrder: FoodOrderDto): String {
        log.info("create food order request received")
        return foodOrderService.createFoodOrder(foodOrder)
    }
}