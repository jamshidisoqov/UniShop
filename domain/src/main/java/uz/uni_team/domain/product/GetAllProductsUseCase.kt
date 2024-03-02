package uz.uni_team.domain.product

import uz.uni_team.data.model.dto.category.CategoryDto
import uz.uni_team.data.model.dto.product.ProductDto
import uz.uni_team.data.repository.product.ProductRepository

class GetAllProductsUseCase(private val productRepository: ProductRepository) {
    suspend operator fun invoke(categoriesList: List<CategoryDto>): List<ProductDto> {
        return productRepository.getAllProducts().map { productResponse ->
            val categoryName = categoriesList.find { it.id == productResponse.categoryId }?.name
            productResponse.mapToProductDto(categoryName ?: "")
        }
    }
}