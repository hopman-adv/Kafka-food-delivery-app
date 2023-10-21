package kafkaconsumer

import kafkaconsumer.model.FoodOrder
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FoodOrderRepository : JpaRepository<FoodOrder, Long>