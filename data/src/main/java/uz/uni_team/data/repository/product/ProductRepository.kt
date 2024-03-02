package uz.uni_team.data.repository.product

import uz.uni_team.data.model.remote.product.ProductResponse

interface ProductRepository {

    suspend fun getAllProducts():List<ProductResponse>

}