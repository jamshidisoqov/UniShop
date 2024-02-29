plugins {
    id("uni_shop.android.application")
    id("uni_shop.android.application.compose")
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    alias(libs.plugins.com.google.dev.ksp)
}

ksp {
    arg("compose-destinations.mode", "destinations")
    arg("compose-destinations.moduleName", "app")
    arg("compose-destinations.useComposableVisibility", "true")
}

android {
    namespace = "uz.uni_team.uni_shop"
    compileSdk = 34

    defaultConfig {
        applicationId = "uz.uni_team.uni_shop"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
            isShrinkResources = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                file("proguard-rules.pro")
            )
            buildConfigField("String", "BASE_URL", "\"url\"")

            buildConfigField("long", "BUILD_DATE", "${System.currentTimeMillis()}L")
        }
        release {
            isMinifyEnabled = false
            isShrinkResources = false
            proguardFiles(
                getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro"
            )

            buildConfigField("String", "BASE_URL", "\"url\"")

            buildConfigField("long", "BUILD_DATE", "${System.currentTimeMillis()}L")
        }
    }

    applicationVariants.all {
        kotlin.sourceSets {
            getByName(name) {
                project.logger.debug("Falovr name -> $flavorName")
                project.logger.debug("Name -> $name")
                kotlin.srcDir("build/generated/ksp/$flavorName$name/kotlin")
            }
        }
    }

}

dependencies {

    //common
    implementation(project(":data"))
    implementation(project(":domain"))

    //feature
    implementation(project(":features:registration"))

    implementation(project(":library:core-ui"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.android.lifecyle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))

    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.preview)
    implementation(libs.androidx.compose.material3)

    //navigation
    ksp(libs.raamcosta.compose.destinations.ksp)
    implementation(libs.raamcosta.compose.destinations.core)
    implementation(libs.raamcosta.compose.destinations.animations)
    debugImplementation(libs.androidx.ui.tooling)

    //koin
    implementation(libs.koin.core)
    implementation(libs.koin.android)
    implementation(libs.koin.androidx.compose.navigation)
    implementation(libs.koin.androidx.compose)
    implementation(platform(libs.koin.bom))
}