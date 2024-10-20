package com.vinaybyte.navdrawer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.vinaybyte.navdrawer.ui.components.AppBar
import com.vinaybyte.navdrawer.ui.components.AppDrawer
import com.vinaybyte.navdrawer.ui.components.SearchBar
import com.vinaybyte.navdrawer.ui.navigation.NavScreen
import com.vinaybyte.navdrawer.ui.navigation.Navigation
import com.vinaybyte.navdrawer.ui.theme.AppTheme
import kotlinx.coroutines.launch

/**
 * @Author: Vinay
 * @Date: 20-10-2024
 * @Github:VinayByte
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MainScreen() {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()
    ModalNavigationDrawer(
        modifier = Modifier.statusBarsPadding(),
        drawerState = drawerState,
        drawerContent = {
            AppDrawer(modifier = Modifier, onItemClick = {
                scope.launch {
                    navController.navigate(it.route)
                    drawerState.close()
                }
            })
        }
    ) {
        Navigation(
            navController = navController, modifier = Modifier
                .consumeWindowInsets(
                    PaddingValues(16.dp)
                ), drawerState = drawerState,
            scope = scope
        )
    }
}

@Composable
fun HomeScreen(navController: NavHostController, modifier: Modifier, onDrawerClick: () -> Unit) {
    Column(modifier = modifier) {
        // Top Search Bar
        SearchBar(
            onDrawerClick = onDrawerClick,
            onSearchClick = { navController.navigate(NavScreen.SearchScreen.route) }
        )

        // Chips Row
        var selectedChip by remember { mutableStateOf("Home") }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Chip(
                text = "Home",
                selected = selectedChip == "Home",
                onClick = { selectedChip = "Home" }
            )
            Chip(
                text = "News",
                selected = selectedChip == "News",
                onClick = { selectedChip = "News" }
            )
            Chip(
                text = "Others",
                selected = selectedChip == "Others",
                onClick = { selectedChip = "Others" }
            )
        }
        when (selectedChip) {
            "Home" -> HomeContent()
            "News" -> NewsContent()
            "Others" -> OthersContent()
        }
    }
}

@Composable
fun Chip(text: String, selected: Boolean, onClick: () -> Unit) {
    FilterChip(
        onClick = { onClick() },
        label = {
            Text(text)
        },
        selected = selected,
    )
}

@Composable
fun HomeContent() {
    Text("Home Content", modifier = Modifier.padding(16.dp))
}

@Composable
fun NewsContent() {
    Text("News Content", modifier = Modifier.padding(16.dp))
}

@Composable
fun OthersContent() {
    Text("Others Content", modifier = Modifier.padding(16.dp))
}

@Composable
fun NavContentScreen(
    screenTitle: String,
    navController: NavHostController
) {
    Column {
        AppBar(screenTitle) {
            navController.navigateUp()
        }
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = screenTitle)
        }
    }
}


