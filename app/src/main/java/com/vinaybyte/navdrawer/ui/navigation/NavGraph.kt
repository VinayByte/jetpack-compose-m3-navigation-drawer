package com.vinaybyte.navdrawer.ui.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material3.DrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.vinaybyte.navdrawer.HomeScreen
import com.vinaybyte.navdrawer.NavContentScreen
import com.vinaybyte.navdrawer.ui.screens.SearchScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 * @Author: Vinay
 * @Date: 20-10-2024
 * @Github:VinayByte
 */
@Composable
@ExperimentalAnimationApi
fun Navigation(
    navController: NavHostController,
    modifier: Modifier,
    drawerState: DrawerState,
    scope: CoroutineScope,
) {
    NavHost(navController = navController, startDestination = NavScreen.HomeScreen.route) {
        composable(NavScreen.HomeScreen.route) {
            HomeScreen(
                navController = navController,
                modifier = modifier,
                onDrawerClick = { scope.launch { drawerState.open() } })
        }
        composable(NavScreen.SearchScreen.route) {
            SearchScreen(navController = navController)
        }
        composable(NavScreen.SettingsScreen.route) {
            NavContentScreen(
                NavScreen.SettingsScreen.route,
                navController = navController
            )
        }
        composable(NavScreen.AboutScreen.route) {
            NavContentScreen(
                NavScreen.AboutScreen.route,
                navController = navController
            )
        }
        composable(NavScreen.RateScreen.route) {
            NavContentScreen(
                NavScreen.RateScreen.route,
                navController = navController
            )
        }
    }
}