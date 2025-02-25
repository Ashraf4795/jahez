pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
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

rootProject.name = "Jahez"
include(":app")
include(":ui")
include(":ui-model")
include(":feature:home")
include(":common_res")
include(":data_model")
include(":feature:product_details")
include(":address")
include(":home-data")
include(":product-details-data")
include(":core")
include(":build-logic")
include(":feature:merchant-menu")
include(":feature:basket")
include(":navigation")