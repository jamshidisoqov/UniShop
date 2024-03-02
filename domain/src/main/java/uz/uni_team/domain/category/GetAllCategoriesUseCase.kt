package uz.uni_team.domain.category

import uz.uni_team.data.model.dto.category.CategoryDto
import uz.uni_team.data.repository.category.CategoryRepository

class GetAllCategoriesUseCase(private val categoryRepository: CategoryRepository) {
    suspend operator fun invoke(): List<CategoryDto> {
        return categoryRepository.getAllCategories().map { it.mapToCategoryDto() }
    }
}