package Kafkaproducer.configuration

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.boot.autoconfigure.kafka.KafkaProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.TopicBuilder
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory

@Configuration
class KafkaConfig(
    val kafkaProperties: KafkaProperties,
) {

    @Bean
    fun producerFactory(): ProducerFactory<String, Any> {
        return DefaultKafkaProducerFactory(kafkaProperties.buildProducerProperties())
    }

    @Bean
    fun kafkaTemplate(): KafkaTemplate<String, Any> {
        return KafkaTemplate(producerFactory())
    }

    @Bean
    fun topic(): NewTopic {
        return TopicBuilder
            .name("t.food.order")
            .partitions(1)
            .replicas(1)
            .build()
    }

}