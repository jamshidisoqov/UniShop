/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uz.uni_team.uni_shop.convention

import com.android.build.api.dsl.CommonExtension
import java.io.File
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType

/**
 * Configure Compose-specific options
 */
internal fun Project.configureAndroidCompose(
    commonExtension: CommonExtension<*, *, *, *, *>,
) {
    val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

    commonExtension.apply {
        buildFeatures {
            compose = true
        }

        composeOptions {
            kotlinCompilerExtensionVersion = libs.findVersion("composeCompiler").get().toString()
        }

        kotlinOptions {
            freeCompilerArgs = freeCompilerArgs + buildComposeMetricsParameters()
            freeCompilerArgs = freeCompilerArgs + listOf(
                "-Xopt-in=androidx.compose.ui.ExperimentalComposeUiApi",
                "-Xopt-in=androidx.compose.animation.ExperimentalAnimationApi",
                "-Xopt-in=androidx.compose.material.ExperimentalMaterialApi",
                "-Xopt-in=androidx.compose.runtime.ExperimentalComposeApi",
                "-Xopt-in=androidx.compose.ui.ExperimentalComposeUiApi",
                "-Xopt-in=com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi",
                "-Xopt-in=com.google.accompanist.pager.ExperimentalPagerApi",
                "-Xopt-in=com.google.accompanist.permissions.ExperimentalPermissionsApi",
                "-Xopt-in=kotlin.ExperimentalUnsignedTypes",
                "-Xopt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
                "-Xopt-in=kotlinx.coroutines.InternalCoroutinesAp",
                "-Xopt-in=androidx.compose.ui.unit.ExperimentalUnitApi",
                "-Xopt-in=androidx.compose.foundation.ExperimentalFoundationApi",
                "-Xopt-in=kotlinx.coroutines.InternalCoroutinesApi",
                "-Xopt-in=coil.annotation.ExperimentalCoilApi",
            )
        }
    }
}

private fun Project.buildComposeMetricsParameters(): List<String> {
    val metricParameters = mutableListOf<String>()
    val enableMetricsProvider = project.providers.gradleProperty("enableComposeCompilerMetrics")
    val enableMetrics = (enableMetricsProvider.orNull == "true")
    if (enableMetrics) {
        val metricsFolder = File(project.buildDir, "compose-metrics")
        metricParameters.add("-P")
        metricParameters.add(
            "plugin:androidx.compose.compiler.plugins.kotlin:metricsDestination=" + metricsFolder.absolutePath
        )
    }

    val enableReportsProvider = project.providers.gradleProperty("enableComposeCompilerReports")
    val enableReports = (enableReportsProvider.orNull == "true")
    if (enableReports) {
        val reportsFolder = File(project.buildDir, "compose-reports")
        metricParameters.add("-P")
        metricParameters.add(
            "plugin:androidx.compose.compiler.plugins.kotlin:reportsDestination=" + reportsFolder.absolutePath
        )
    }
    return metricParameters.toList()
}
