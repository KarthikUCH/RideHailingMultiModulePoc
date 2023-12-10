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

rootProject.name = "RideHailingMultiModulePoc"
include(":app")
include(":payment-data")
include(":taxi-data")
include(":payment-ui")
include(":taxi-ui")
include(":navigation")
