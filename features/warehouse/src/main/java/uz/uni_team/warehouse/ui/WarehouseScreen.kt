package uz.uni_team.warehouse.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramcosta.composedestinations.annotation.Destination
import org.koin.androidx.compose.koinViewModel
import uz.uni_team.data.model.dto.category.CategoryDto

@Destination
@Composable
fun WarehouseScreen() {
    val viewModel: WarehouseViewModel = koinViewModel()
    val state by viewModel.state.collectAsState()
    WarehouseContent(state = state)
}

@Composable
fun WarehouseContent(
    state: WarehouseUiState
) {
    Scaffold(modifier = Modifier.fillMaxSize(), containerColor = Color.Black) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
        ) {
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(state.categoryList) { categoryDto ->
                    CategoryItem(categoryDto = categoryDto) {
                        //Todo click logic
                    }
                }
            }
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
            ) {
                //TODO product list
            }
        }
    }
}

@Composable
fun CategoryItem(categoryDto: CategoryDto, onClickCategory: () -> Unit) {
    Box(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 6.dp)
            .clickable(onClick = onClickCategory), contentAlignment = Alignment.Center
    ) {
        Text(text = categoryDto.name, fontSize = 16.sp, color = Color.White)
    }
}
