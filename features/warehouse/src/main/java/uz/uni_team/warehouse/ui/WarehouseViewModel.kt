package uz.uni_team.warehouse.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import uz.uni_team.data.model.dto.category.CategoryDto
import uz.uni_team.data.network.common.resultOf
import uz.uni_team.domain.category.GetAllCategoriesUseCase
import uz.uni_team.domain.product.GetAllProductsUseCase

class WarehouseViewModel(
    private val getAllProductsUseCase: GetAllProductsUseCase,
    private val getAllCategoriesUseCase: GetAllCategoriesUseCase
):ViewModel() {

    private val _state:MutableStateFlow<WarehouseUiState> = MutableStateFlow(WarehouseUiState())
    val state = _state.asStateFlow()

    init {
        getAllCategoriesAndProduct()
    }

    private fun getAllCategoriesAndProduct(){
        viewModelScope.launch {
            getAllCategories()
            val categoryList = _state.value.categoryList
            getAllProduct(categoryList)
        }
    }

    private suspend fun getAllCategories(){
        _state.update {
            it.copy(isLoading = true)
        }
        resultOf {
            getAllCategoriesUseCase.invoke()
        }.onSuccess { categoryList->
            println("Category list:$categoryList")
            _state.update {
                it.copy(
                    isLoading = false,
                    categoryList = categoryList
                )
            }
        }.onFailure {th->
            th.printStackTrace()
            _state.update {
                it.copy(
                    isLoading = false,
                    isError = true,
                    errorMessage = th
                )
            }
        }
    }
    private suspend fun getAllProduct(categoryList: List<CategoryDto>){
        _state.update {
            it.copy(isLoading = true)
        }
        resultOf {
            getAllProductsUseCase.invoke(categoryList)
        }.onSuccess { productList->
            _state.update {
                it.copy(
                    isLoading = false,
                    productList = productList
                )
            }
        }.onFailure {th->
            _state.update {
                it.copy(
                    isLoading = false,
                    isError = true,
                    errorMessage = th
                )
            }
        }
    }
}