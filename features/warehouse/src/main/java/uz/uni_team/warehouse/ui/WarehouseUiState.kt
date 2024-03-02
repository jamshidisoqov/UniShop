package uz.uni_team.warehouse.ui

import androidx.compose.runtime.Immutable
import uz.uni_team.data.model.dto.category.CategoryDto
import uz.uni_team.data.model.dto.product.ProductDto

@Immutable
data class WarehouseUiState(
    val isLoading:Boolean = false,
    val isError:Boolean = false,
    val errorMessage:Throwable = Throwable(),
    val categoryList: List<CategoryDto> = emptyList(),
    val productList: List<ProductDto> = emptyList()
)
