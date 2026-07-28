rootProject.name = "sofatime-patches"

pluginManagement {
    repositories {
        mavenLocal()
        gradlePluginPortal()
        google()
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/MorpheApp/registry")
            credentials {
                username = providers.gradleProperty("gpr.user").orNull 
                    ?: System.getenv("GPR_USER") 
                    ?: System.getenv("GITHUB_ACTOR") 
                    ?: "alan7383"
                password = providers.gradleProperty("gpr.key").orNull 
                    ?: System.getenv("GPR_KEY") 
                    ?: System.getenv("PAT_TOKEN") 
                    ?: System.getenv("GITHUB_TOKEN")
            }
        }
        maven { url = uri("https://jitpack.io") }
    }
}

plugins {
    id("app.morphe.patches") version "1.3.3"
}
