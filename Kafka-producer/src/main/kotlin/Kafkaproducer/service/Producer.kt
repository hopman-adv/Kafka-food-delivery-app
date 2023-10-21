package Kafkaproducer.service

import Kafkaproducer.configuration.properties.KafkaConnectionProperties
import Kafkaproducer.dao.FoodOrderDto
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

private val log = KotlinLogging.logger {}

@Component
class Producer(
    val objectMapper: ObjectMapper,
    val kafkaTemplate: KafkaTemplate<String, Any>,
    val kafkaConnectionProperties: KafkaConnectionProperties
) {
    @Throws(JsonProcessingException::class)
    fun sendMessage(foodOrder: FoodOrderDto): String {
        kafkaTemplate.send(kafkaConnectionProperties.topicName, foodOrder)
        log.info("food order produced {}", foodOrder)
        return "message sent"
    }

}
