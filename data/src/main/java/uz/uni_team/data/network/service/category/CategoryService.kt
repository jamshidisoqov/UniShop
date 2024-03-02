package uz.uni_team.data.network.service.category

import uz.uni_team.data.model.remote.category.CategoryResponse

interface CategoryService {

    suspend fun getAllCategories():List<CategoryResponse>

}