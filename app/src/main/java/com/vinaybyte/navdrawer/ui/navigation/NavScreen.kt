package com.vinaybyte.navdrawer.ui.navigation

/**
 * @Author: Vinay
 * @Date: 20-10-2024
 * @Github:VinayByte
 */
sealed class NavScreen(val route: String) {
    object HomeScreen : NavScreen("home")
    object SearchScreen : NavScreen("search_screen")
    object SettingsScreen : NavScreen("settings")
    object AboutScreen : NavScreen("about")
    object RateScreen : NavScreen("rate")
}