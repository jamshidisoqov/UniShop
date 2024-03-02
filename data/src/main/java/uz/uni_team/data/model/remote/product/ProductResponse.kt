package uz.uni_team.data.model.remote.product

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import uz.uni_team.data.model.dto.product.ProductDto


@Serializable
data class ProductResponse(
    @SerialName(value = "id") val productId: Long? = null,
    val name: String? = null,
    val description: String? = null,
    val brand: String? = null,
    val quantity: Int? = null,
    val price: Double? = null,
    val minimumPrice: Double? = null,
    val maximumPrice: Double? = null,
    val categoryId: Int? = null,
) {
    fun mapToProductDto(categoryName:String): ProductDto {
        return ProductDto(
            productId = productId ?: 0L,
            name = name ?: "",
            description = description ?: "",
            brand = brand ?: "",
            quantity = quantity ?: 0,
            price = price ?: 0.0,
            minimumPrice = minimumPrice ?: 0.0,
            maximumPrice = maximumPrice ?: 0.0,
            categoryId = categoryId ?: 0,
            categoryName = categoryName
        )
    }
}
