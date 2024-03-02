package uz.uni_team.home.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramcosta.composedestinations.annotation.Destination
import uz.uni_team.core_ui_resources.R

@Destination
@Composable
fun HomeScreen(onClickWareHouse: () -> Unit) {
    HomeContent(
        onClickSale = {

        },
        onClickWareHouse = onClickWareHouse,
    )
}

@Composable
private fun HomeContent(
    onClickSale: () -> Unit, onClickWareHouse: () -> Unit
) {
    Column(
        modifier = Modifier
            .background(color = Color.Black)
            .fillMaxSize()
            .padding(12.dp),
    ) {
        Spacer(modifier = Modifier.size(8.dp))
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = "",
                modifier = Modifier.size(32.dp),
                colorFilter = ColorFilter.tint(color = Color.White)
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                text = stringResource(id = R.string.app_name),
                fontSize = 18.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.size(24.dp))
        DashboardItem(
            iconId = R.drawable.ic_sale, title = "New sale", onDashboardClick = onClickSale
        )
        Spacer(modifier = Modifier.size(24.dp))
        DashboardItem(
            iconId = R.drawable.ic_warehouse,
            title = "Warehouse",
            onDashboardClick = onClickWareHouse
        )
    }
}

@Composable
private fun DashboardItem(
    @DrawableRes iconId: Int, title: String, onDashboardClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .clickable(onClick = onDashboardClick)
            .padding(horizontal = 4.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = iconId),
            contentDescription = "",
            modifier = Modifier.size(40.dp),
        )
        Spacer(modifier = Modifier.size(8.dp))
        Text(
            text = title, fontSize = 20.sp, color = Color.White, fontWeight = FontWeight.Bold
        )
    }
}