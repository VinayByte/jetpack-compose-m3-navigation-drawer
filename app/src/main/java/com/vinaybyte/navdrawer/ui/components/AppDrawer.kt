package com.vinaybyte.navdrawer.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.vinaybyte.navdrawer.R
import com.vinaybyte.navdrawer.ui.navigation.NavScreen

/**
 * @Author: Vinay
 * @Date: 20-10-2024
 * @Github:VinayByte
 */
val drawerItems = listOf(
    Pair(R.string.drawer_title_home, NavScreen.HomeScreen),
    Pair(R.string.drawer_title_settings, NavScreen.SettingsScreen),
    Pair(R.string.screen_title_about, NavScreen.AboutScreen),
    Pair(R.string.screen_title_rate, NavScreen.RateScreen)
)

@Composable
fun AppDrawer(modifier: Modifier = Modifier, onItemClick: (NavScreen) -> Unit) {
    Column(
        modifier = modifier
            .fillMaxWidth(0.8f)
            .background(Color.White)
            .padding(start = 48.dp, top = 48.dp)
    ) {
        Image(
            modifier = Modifier.scale(scaleX = -1f, scaleY = 1f),
            painter = painterResource(R.drawable.ic_account),
            contentDescription = stringResource(R.string.cd_drawer),
            colorFilter = ColorFilter.tint(Color.Black),
        )
        for ((title, screen) in drawerItems) {
            Spacer(Modifier.height(24.dp))
            Text(
                text = stringResource(id = title),
                color = Color.Black,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.clickable { onItemClick(screen) }
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(id = R.string.version),
                color = Color.Black,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}