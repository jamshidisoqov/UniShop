plugins {
    `kotlin-dsl`
}

group = "uz.uni_team.uni_shop.buildlogic"
java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    compileOnly(libs.android.pluginGradle)
    compileOnly(libs.kotlin.pluginGradle)
}

gradlePlugin {
    plugins {
        register("androidApplicationCompose") {
            id = "uni_shop.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("androidApplication") {
            id = "uni_shop.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = "uni_shop.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
        register("androidLibrary") {
            id = "uni_shop.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidFeature") {
            id = "uni_shop.android.feature"
            implementationClass = "AndroidComposeFeatureConventionPlugin"
        }
        register("androidRoom") {
            id = "uni_shop.android.room"
            implementationClass = "AndroidRoomConventionPlugin"
        }
        register("koinLibrary"){
            id = "uni_shop.android.koin"
            implementationClass = "AndroidKoinConventionPlugin"
        }
    }
}
