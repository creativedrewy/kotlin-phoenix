# Kotlin Phoenix

[![Maven Central](https://img.shields.io/badge/Maven%20Central-1.0.3-%23007ec6)](https://search.maven.org/search?q=g:%22io.github.ajacquierbret%22%20AND%20a:%22kotlinphoenix-client%22)
![Android](https://img.shields.io/badge/platform-android-%23a4c639)
![iOS](https://img.shields.io/badge/platform-ios-%23007AFF)

See API reference: https://ajacquierbret.github.io/kotlin-phoenix

This project is aimed to allow developers to work with Phoenix Channels in Kotlin Multiplatform projects, and is composed of several modules:

- A modern Kotlin Multiplatform Phoenix Channels client, built with coroutines.
- Adapters designed for specific GraphQL clients (e.g. Apollo Client) allowing them to handle subscriptions via Phoenix Channels

**As of now, this project is still experimental and should NOT be used in production.
Please feel free to contribute and to share feedbacks and issues.**

## Modules

- [Kotlin Phoenix Client](https://github.com/ajacquierbret/kotlin-phoenix/tree/main/kotlinphoenix-client)
- [Kotlin Phoenix Adapters](https://github.com/ajacquierbret/kotlin-phoenix/tree/main/kotlinphoenix-adapters)

## Installation

Add the `mavenCentral` repository

```kotlin
// build.gradle.kts

repositories {
  mavenCentral()
}
```

Add the `kotlinphoenix` dependency in `commonMain` source set.

```kotlin
// shared/build.gradle.kts

sourceSets {
  val commonMain by getting {
    dependencies {
	implementation("io.github.ajacquierbret:kotlinphoenix-$moduleName:1.0.3")
    }
  }
}
```

## Usage

See each module's documentation for example usages.

## Roadmap

- [x] Fork and re-design the [JavaPhoenixClient](https://github.com/dsrees/JavaPhoenixClient) library in order to build a Multiplatform library (at least iOS & Android), using `OkHttp` for Android and `NSUrlSession` for iOS
- [x] Switch all the [JavaPhoenixClient](https://github.com/dsrees/JavaPhoenixClient) library callbacks to a coroutine based approach
- [x] Publish this brand new library as [Kotlin Phoenix Client](https://github.com/ajacquierbret/kotlin-phoenix/tree/main/kotlinphoenix-client) on Github and Maven
- [x] Create a [PhoenixNetworkTransport](https://github.com/ajacquierbret/kotlin-phoenix/blob/main/kotlinphoenix-adapters/src/commonMain/kotlin/io/github/ajacquierbret/kotlinphoenix/adapters/apollo/PhoenixNetworkTransport.kt) adapter for Apollo Kotlin using Kotlin Phoenix Client, which will be available in the same repo, but inside another module.
- [x] Clean both module's code and add detailed comment blocks
- [x] Host Dokka generated API reference on Github Pages
- [ ] Write and host proper documentation
- [ ] Refactor Presence with coroutines and suspending functions
- [ ] Mock a simple Phoenix server & test the Kotlin Phoenix library
- [ ] Encourage the community to contribute to the project

## Contributing
I strongly believe that this library will be useful to a lot of Kotlin developers wishing to create engaging Phoenix Channels experiences on many platforms !

**Any contribution, issue, feature request, feedback you make is greatly appreciated !**
## License
Distributed under the MIT License. See [LICENSE](https://github.com/ajacquierbret/kotlin-phoenix/blob/main/LICENSE) for more information.

## Acknowledgments
Huge thanks to these people, they helped a lot in many different ways:

- [@dsrees](https://github.com/dsrees) – For the [JavaPhoenixClient](https://github.com/dsrees/JavaPhoenixClient) library on which this project is based.
- [@martinbonnin](https://github.com/martinbonnin) and [@BoD](https://github.com/BoD) – For their golden advices and help building the project !
