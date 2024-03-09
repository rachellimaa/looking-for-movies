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
include(
    ":gg:app",
    ":gg:core:models",
    ":gg:core:repository",
    ":gg:feature:listmovies",
    ":gg:core:network"
)