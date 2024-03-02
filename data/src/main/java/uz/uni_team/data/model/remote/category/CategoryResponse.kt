package uz.uni_team.data.model.remote.category

import kotlinx.serialization.Serializable
import uz.uni_team.data.model.dto.category.CategoryDto

@Serializable
data class CategoryResponse(
    val id: Int? = null,
    val name: String? = null,
) {
    fun mapToCategoryDto(): CategoryDto {
        return CategoryDto(
            id = id ?: 0, name = name ?: ""
        )
    }
}
