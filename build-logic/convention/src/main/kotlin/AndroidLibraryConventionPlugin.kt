import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import uz.uni_team.uni_shop.convention.configureKotlinAndroid

class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<LibraryExtension> {
                configureKotlinAndroid(this)
                defaultConfig.targetSdk = 34

                sourceSets.configureEach {
                    kotlin.srcDir("$buildDir/generated/ksp/$name/kotlin/")
                }
                buildFeatures {
                    buildConfig = true
                }
            }
        }
    }
}