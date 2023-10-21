package Kafkaproducer.configuration.properties

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "kafka.connection")
class KafkaConnectionProperties(val topicName: String)