pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}


dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositories {
        google()  // Google's Maven repository
        mavenCentral()
    }
}
rootProject.name = "WTW"
include(":app")
