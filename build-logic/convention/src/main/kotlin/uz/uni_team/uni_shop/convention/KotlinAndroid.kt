package uz.uni_team.uni_shop.convention

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Action
import org.gradle.api.JavaVersion
import org.gradle.api.NamedDomainObjectProvider
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionAware
import org.gradle.kotlin.dsl.named
import org.gradle.kotlin.dsl.provideDelegate
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions
import org.jetbrains.kotlin.gradle.internal.Kapt3GradleSubplugin.Companion.isUseJvmIr
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet


internal fun Project.configureKotlinAndroid(
    commonExtension: CommonExtension<*, *, *, *, *>,
) {
    commonExtension.apply {
        compileSdk = 34

        defaultConfig {
            minSdk = 21
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_17
            targetCompatibility = JavaVersion.VERSION_17
        }

        flavorDimensions += "device"
        productFlavors {
            create("emulator") {
                dimension = "device"
                buildConfigField("boolean", "EMULATED", "true")
            }
        }

        kotlinOptions {
            val warningsAsErrors: String? by project
            allWarningsAsErrors = warningsAsErrors.toBoolean()
            freeCompilerArgs = freeCompilerArgs + listOf(
                "-opt-in=kotlin.RequiresOptIn",
                "-opt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
                "-opt-in=kotlinx.coroutines.FlowPreview",
                "-opt-in=kotlin.Experimental",
            )
            jvmTarget = JavaVersion.VERSION_17.toString()
            isUseJvmIr()
        }
    }
}

fun CommonExtension<*, *, *, *, *>.kotlinOptions(block: KotlinJvmOptions.() -> Unit) {
    (this as ExtensionAware).extensions.configure("kotlinOptions", block)
}

/**
 * Configures the [kotlin][org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension] extension.
 */
fun Project.kotlin(configure: Action<org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension>): Unit =
    (this as ExtensionAware).extensions.configure("kotlin", configure)

/**
 * Configures the [sourceSets][org.gradle.api.NamedDomainObjectContainer<org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet>] extension.
 */
fun org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension.sourceSets(configure: Action<org.gradle.api.NamedDomainObjectContainer<KotlinSourceSet>>): Unit =
    (this as ExtensionAware).extensions.configure("sourceSets", configure)

/**
 * Provides the existing [debug][org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet] element.
 */
val org.gradle.api.NamedDomainObjectContainer<KotlinSourceSet>.debug: NamedDomainObjectProvider<KotlinSourceSet>
    get() = named<KotlinSourceSet>("debug")

/**
 * Provides the existing [release][org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet] element.
 */
val org.gradle.api.NamedDomainObjectContainer<KotlinSourceSet>.release: NamedDomainObjectProvider<KotlinSourceSet>
    get() = named<KotlinSourceSet>("release")
