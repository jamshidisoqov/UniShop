package uz.uni_team.data.repository.category

import uz.uni_team.data.model.remote.category.CategoryResponse

interface CategoryRepository {

    suspend fun getAllCategories():List<CategoryResponse>

}