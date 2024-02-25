package uz.uni_team.uni_shop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import androidx.navigation.plusAssign
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.ModalBottomSheetLayout
import com.google.accompanist.navigation.material.rememberBottomSheetNavigator
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.animations.defaults.NestedNavGraphDefaultAnimations
import com.ramcosta.composedestinations.animations.defaults.RootNavGraphDefaultAnimations
import com.ramcosta.composedestinations.animations.rememberAnimatedNavHostEngine
import uz.uni_team.core_ui.theme.UniShopTheme
import uz.uni_team.registration.navigation.registrationNavGraph
import uz.uni_team.uni_shop.navigation.RootNavGraph
import uz.uni_team.uni_shop.navigation.splashGraph

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterialNavigationApi::class, ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UniShopTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val bottomSheetNavigator = rememberBottomSheetNavigator()
                    navController.navigatorProvider += bottomSheetNavigator

                    ModalBottomSheetLayout(
                        bottomSheetNavigator = bottomSheetNavigator,
                        sheetShape = RoundedCornerShape(16.dp),
                    ) {

                        val animation = NestedNavGraphDefaultAnimations(
                            enterTransition = {
                                slideIntoContainer(
                                    AnimatedContentTransitionScope.SlideDirection.Left,
                                    animationSpec = tween(300)
                                )
                            },
                            exitTransition = {
                                slideOutOfContainer(
                                    AnimatedContentTransitionScope.SlideDirection.Left,
                                    animationSpec = tween(300)
                                )
                            },
                            popExitTransition = {
                                slideOutOfContainer(
                                    AnimatedContentTransitionScope.SlideDirection.Right,
                                    animationSpec = tween(300)
                                )
                            },
                            popEnterTransition = {
                                slideIntoContainer(
                                    AnimatedContentTransitionScope.SlideDirection.Right,
                                    animationSpec = tween(300)
                                )
                            },
                        )

                        val animatedNavHostEngine = rememberAnimatedNavHostEngine(
                            navHostContentAlignment = Alignment.TopCenter,
                            rootDefaultAnimations = RootNavGraphDefaultAnimations(),
                            defaultAnimationsForNestedNavGraph = mapOf(
                                splashGraph to animation,
                                registrationNavGraph to animation,
                            )
                        )

                        DestinationsNavHost(
                            navController = navController,
                            engine = animatedNavHostEngine,
                            navGraph = RootNavGraph
                        )
                    }
                }
            }
        }
    }
}
