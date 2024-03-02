package uz.uni_team.data.network.service.category

import io.ktor.client.HttpClient
import uz.uni_team.data.model.remote.category.CategoryResponse
import uz.uni_team.data.network.common.getJson

class CategoryServiceImpl(private val client: HttpClient) : CategoryService {
    override suspend fun getAllCategories(): List<CategoryResponse> {
        return client.getJson(API_GET_CATEGORIES)
    }

    companion object {
        const val API_GET_CATEGORIES = "/api/v1/category/all"
    }
}