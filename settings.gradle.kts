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
    ":gg:core:database",
    ":gg:feature:listmovies",
    ":gg:feature:favoritelist",
    ":gg:core:network",
    ":gg:core:common",
    ":gg:core:uicomponents"
)