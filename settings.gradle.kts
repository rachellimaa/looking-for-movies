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

rootProject.name = "LookingForMovies"
include(":gg:app")
include(":gg:core:models")
include(":gg:data:movies")
include(":gg:feature:listmovies")
include(":gg:core:network")