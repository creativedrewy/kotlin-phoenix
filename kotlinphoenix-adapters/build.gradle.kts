plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
}

version = project.rootProject.version
group = "io.github.ajacquierbret"
description = "Adapters for using Kotlin Phoenix with third-party GraphQL clients"

kotlin {
    androidTarget()
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = description
        homepage = "https://github.com/ajacquierbret/kotlin-phoenix/kotlinphoenix-adapters"
        ios.deploymentTarget = "14.1"
        framework {
            baseName = "kotlinphoenix-adapters"
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