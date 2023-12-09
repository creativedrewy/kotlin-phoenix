plugins {
    kotlin("multiplatform")
    id("com.android.library")
}

version = project.rootProject.version
group = "io.github.ajacquierbret"
description = "Adapters for using Kotlin Phoenix with third-party GraphQL clients"

kotlin {
    androidTarget()

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "kotlinphoenix-adapters"
            isStatic = true
        }
    }

    androidTarget {
        publishLibraryVariants("release", "debug")
    }
    
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":kotlinphoenix-client"))
                implementation("com.apollographql.apollo3:apollo-runtime:3.1.0")
            }
        }
    }
}

android {
    namespace = "com.drip.haus.authscreen"
    compileSdk = 34

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")

    defaultConfig {
        minSdk = 21
        targetSdk = 34
    }
}