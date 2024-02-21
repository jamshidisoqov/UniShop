pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "UniShop"
include(":app")
include(":features:registration")
include(":features:login")
include(":features:home")
include(":features:finance")
include(":features:order")
include(":features:clients")
include(":features:warehouse")
include(":features:debt")
include(":data")
include(":domain")
include(":library:framework")
include(":library:core-ui")
include(":library:core-ui-resources")
