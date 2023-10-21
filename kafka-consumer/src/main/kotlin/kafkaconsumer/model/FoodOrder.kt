package kafkaconsumer.model

import jakarta.persistence.*

@Entity
data class FoodOrder(
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    val id: Long?,
    val item: String,
    val amount: Double
)