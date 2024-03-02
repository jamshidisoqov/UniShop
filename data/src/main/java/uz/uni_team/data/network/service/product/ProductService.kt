package uz.uni_team.data.network.service.product

import uz.uni_team.data.model.remote.product.ProductResponse

interface ProductService {
    suspend fun getAllProducts():List<ProductResponse>
}