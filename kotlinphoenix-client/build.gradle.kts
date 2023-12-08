plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    kotlin("plugin.serialization") version "1.6.10"
    id("com.android.library")
}

version = project.rootProject.version
group = "io.github.ajacquierbret"
description = "A Phoenix client written in Kotlin, multiplatform and backed by coroutines"

kotlin {
    androidTarget()
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = description
        homepage = "https://github.com/ajacquierbret/kotlin-phoenix/kotlinphoenix-client"
        ios.deploymentTarget = "14.1"
        framework {
            baseName = "kotlinphoenix-client"
        }
    }

    androidTarget {
        publishLibraryVariants("release", "debug")
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.kotlinx.serialization.json)
                implementation(libs.kotlinx.coroutines.core)
            }
        }

        val androidMain by getting {
            dependencies {
                implementation(libs.okhttp)
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