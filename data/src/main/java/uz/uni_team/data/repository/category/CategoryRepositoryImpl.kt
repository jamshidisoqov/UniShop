package uz.uni_team.data.repository.category

import uz.uni_team.data.model.remote.category.CategoryResponse
import uz.uni_team.data.network.service.category.CategoryService

class CategoryRepositoryImpl(private val categoryService: CategoryService) : CategoryRepository {
    override suspend fun getAllCategories(): List<CategoryResponse> {
        return categoryService.getAllCategories()
    }
}