package uz.uni_team.data.repository.product

import uz.uni_team.data.model.remote.product.ProductResponse
import uz.uni_team.data.network.service.product.ProductService

class ProductRepositoryImpl(
    private val productService: ProductService
) : ProductRepository {
    override suspend fun getAllProducts(): List<ProductResponse> {
        return productService.getAllProducts()
    }
}