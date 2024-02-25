import com.android.build.gradle.AppExtension
import com.android.build.gradle.AppPlugin
import com.android.build.gradle.BaseExtension
import com.android.build.gradle.LibraryPlugin

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.2.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.com.google.dev.ksp) apply false
}


allprojects {
    repositories {
        maven(url = "https://jitpack.io")
        maven(url = "https://plugins.gradle.org/m2/")
        mavenCentral()
    }

    tasks.withType(org.jetbrains.kotlin.gradle.tasks.KotlinCompile::class).all {
        kotlinOptions {
            freeCompilerArgs = freeCompilerArgs + listOf(
                // Avoid having to stutter experimental annotations all over the codebase
                "-Xopt-in=androidx.compose.animation.ExperimentalAnimationApi",
                "-Xopt-in=androidx.compose.material.ExperimentalMaterialApi",
                "-Xopt-in=androidx.compose.runtime.ExperimentalComposeApi",
                "-Xopt-in=androidx.compose.ui.ExperimentalComposeUiApi",
                "-Xopt-in=com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi",
                "-Xopt-in=com.google.accompanist.pager.ExperimentalPagerApi",
                "-Xopt-in=com.google.accompanist.permissions.ExperimentalPermissionsApi",
                "-Xopt-in=kotlin.ExperimentalUnsignedTypes",
                "-Xopt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
                "-Xopt-in=kotlinx.coroutines.InternalCoroutinesApi"
            )
        }
    }
}

subprojects {
    val javaVersion: JavaVersion = JavaVersion.VERSION_17

    repositories {
        google()
        mavenCentral()
        maven(url = "https://dl.bintray.com/korlibs/korlibs")
        maven(url = "https://jitpack.io")
        maven(url = "https://oss.sonatype.org/content/repositories/snapshots")
        maven(url = "https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
    apply(plugin = "com.google.devtools.ksp")

    plugins.matching { it is AppPlugin || it is LibraryPlugin }.whenPluginAdded {
        configure<BaseExtension> {

            compileSdkVersion(34)

            compileOptions {
                sourceCompatibility = javaVersion
                targetCompatibility = javaVersion
            }

            defaultConfig {
                minSdk = 21
                targetSdk = 34
                versionCode(1)
                versionName("1.0")
                consumerProguardFile("consumer-rules.pro")
                vectorDrawables.useSupportLibrary = true

                testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

            }

            packagingOptions {
                with(excludes) {
                    add("META-INF/ASL2.0")
                    add("META-INF/DEPENDENCIES")
                    add("META-INF/INDEX.LIST")
                    add("META-INF/LICENSE")
                    add("META-INF/LICENSE.txt")
                    add("META-INF/NOTICE")
                    add("META-INF/NOTICE.txt")
                    add("META-INF/*.kotlin_module")
                    add("META-INF/license.txt")
                    add("META-INF/notice.txt")
                    add("META-INF/io.netty.versions.properties")
                    add("META-INF/gradle/incremental.annotation.processors")
                }
            }

            when (this) {
                is AppExtension -> {
                    packagingOptions {
                        with(excludes) {
                            add("META-INF/*.kotlin_module")
                        }
                    }

                    applicationVariants.all {
                        val appId = applicationId.split(".").last()
                        val buildType = buildType.name
                        val versionName = versionName?.replace(".", "-")
                        outputs.map { it as com.android.build.gradle.internal.api.BaseVariantOutputImpl }
                            .forEach { it.outputFileName = "$appId-$buildType-v$versionName.apk" }
                    }
                }
            }

        }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}