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
buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("com.vanniktech:gradle-dependency-graph-generator-plugin:0.8.0")
    }
}

rootProject.name = "RideHailingMultiModulePoc"
include(":app")
include(":payment-data")
include(":taxi-data")
include(":payment-ui")
include(":taxi-ui")
include(":navigation")
