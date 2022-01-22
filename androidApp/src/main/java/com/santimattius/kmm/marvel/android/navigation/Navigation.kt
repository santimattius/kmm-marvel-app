package com.santimattius.kmm.marvel.android.navigation

import androidx.compose.animation.*
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import coil.annotation.ExperimentalCoilApi
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.santimattius.kmm.marvel.android.detail.ui.DetailScreen
import com.santimattius.kmm.marvel.android.home.ui.HomeScreen
import com.santimattius.kmm.marvel.android.splash.SplashScreen


@ExperimentalAnimationApi
@ExperimentalMaterialApi
@ExperimentalCoilApi
@ExperimentalFoundationApi
@Composable
fun Navigation() {

    BoxWithConstraints {
        val navController = rememberAnimatedNavController()

        AnimatedNavHost(
            navController = navController,
            startDestination = NavigationItem.Splash.route,
        ) {
            navDefinitions(
                navController = navController,
                width = constraints.maxWidth / 2
            )
        }
    }

}

@ExperimentalAnimationApi
@ExperimentalMaterialApi
@ExperimentalCoilApi
@ExperimentalFoundationApi
private fun NavGraphBuilder.navDefinitions(
    navController: NavController,
    width: Int,
) {
    composable(navItem = NavigationItem.Splash, content = {
        SplashScreen(navigate = {
            navController.popBackStack()
            navController.navigate(NavigationItem.Home.route)
        })
    })
    composable(
        navItem = NavigationItem.Home,
        content = {
            HomeScreen(
                onClick = { character ->
                    navController.navigate(NavigationItem.CharacterDetail.createRoute(character.id))
                },
            )
        },
        exitTransition = {
            slideOutHorizontally(
                targetOffsetX = { -width },
                animationSpec = tween(
                    durationMillis = 300,
                    easing = FastOutSlowInEasing
                )
            ) + fadeOut(animationSpec = tween(300))
        },
        popEnterTransition = {
            slideInHorizontally(
                initialOffsetX = { -width },
                animationSpec = tween(
                    durationMillis = 300,
                    easing = FastOutSlowInEasing
                )
            ) + fadeIn(animationSpec = tween(300))
        },
    )
    composable(
        navItem = NavigationItem.CharacterDetail,
        content = {
            val id = it.findArg<Int>(NavArg.ItemId)
            DetailScreen(
                characterId = id,
                onUpClick = { navController.popBackStack() },
            )
        },
        enterTransition = {
            slideInHorizontally(
                initialOffsetX = { width },
                animationSpec = tween(
                    durationMillis = 300,
                    easing = FastOutSlowInEasing
                )
            ) + fadeIn(animationSpec = tween(300))
        },
        popExitTransition = {
            slideOutHorizontally(
                targetOffsetX = { width },
                animationSpec = tween(
                    durationMillis = 300,
                    easing = FastOutSlowInEasing
                )
            ) + fadeOut(animationSpec = tween(300))
        }
    )
}

@ExperimentalAnimationApi
private fun NavGraphBuilder.composable(
    navItem: NavigationItem,
    content: @Composable (NavBackStackEntry) -> Unit,
    enterTransition: () -> EnterTransition? = { null },
    exitTransition: () -> ExitTransition? = { null },
    popEnterTransition: () -> EnterTransition? = enterTransition,
    popExitTransition: () -> ExitTransition? = exitTransition,
) {
    composable(
        route = navItem.route,
        arguments = navItem.args,
        enterTransition = { _, _ -> enterTransition() },
        exitTransition = { _, _ -> exitTransition() },
        popEnterTransition = { _, _ -> popEnterTransition() },
        popExitTransition = { _, _ -> popExitTransition() }
    ) {
        content(it)
    }
}

private inline fun <reified T> NavBackStackEntry.findArg(arg: NavArg): T {
    val value = arguments?.get(arg.key)
    requireNotNull(value)
    return value as T
}