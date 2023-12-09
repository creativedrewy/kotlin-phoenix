plugins {
    kotlin("multiplatform")
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

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "kotlinphoenix-client"
            isStatic = true
        }
    }

    androidTarget {
        publishLibraryVariants("release", "debug")
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.1")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
            }
        }

        val androidMain by getting {
            dependencies {
                implementation("com.squareup.okhttp3:okhttp:4.12.0")
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