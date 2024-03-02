package uz.uni_team.data.model.dto.product

data class ProductDto(
    val productId: Long,
    val name: String,
    val description: String,
    val brand: String,
    val quantity: Int,
    val price: Double,
    val minimumPrice: Double,
    val maximumPrice: Double,
    val categoryId: Int,
    val categoryName:String
)
