package uz.uni_team.data.network.service.product

import io.ktor.client.HttpClient
import uz.uni_team.data.model.remote.product.ProductResponse
import uz.uni_team.data.network.common.getJson

class ProductServiceImpl(private val client: HttpClient) : ProductService {
    override suspend fun getAllProducts(): List<ProductResponse> {
        return client.getJson(API_GET_ALL_PRODUCTS)
    }

    companion object{
        const val API_GET_ALL_PRODUCTS = "/api/v1/product/all"
    }

}