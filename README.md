# KMM Marvel App

Application using Kotlin Mobile Multi Platform and Marvel API.

Oficial documentation: https://kotlinlang.org/lp/mobile/

## Screenshots

### Android App
<p align="center">
  <img height="600" src="https://github.com/santimattius/kmm-marvel-app/blob/master/screenshots/kmm_android_home.png?raw=true" alt="Android Home Screen"/>
  <img height="600" src="https://github.com/santimattius/kmm-marvel-app/blob/master/screenshots/kmm_android_detail.png?raw=true" alt="Android Detail Screen"/>
</p>

### iOS App
<p align="center">
  <img height="600" src="https://github.com/santimattius/kmm-marvel-app/blob/master/screenshots/kmm_ios_home.png?raw=true" alt="iOS Home Screen"/>
  <img height="600" src="https://github.com/santimattius/kmm-marvel-app/blob/master/screenshots/kmm_ios_detail.png?raw=true" alt="iOS Detail Screen"/>
</p>

## Application architecture

In the following images you will see how the app is built and what its levels of abstraction are.

### General

<p align="left">
  <img height="600" src="https://github.com/santimattius/kmm-marvel-app/blob/master/screenshots/kmm-components.png?raw=true" alt="general architecture"/>
</p>

### Project structure

<p align="left">
  <img width="700" src="https://github.com/santimattius/kmm-marvel-app/blob/master/screenshots/basic-project-structure.png?raw=true" alt="Project packages"/>
</p>

## Dependencies

Below you will find the libraries used to build the template and according to my criteria the most used in android development so far.

### Shared
- [Ktor for networking](https://kotlinlang.org/docs/mobile/use-ktor-for-networking.html)  
- [Kotlin serialization](https://kotlinlang.org/docs/serialization.html)
- [Koin](https://insert-koin.io/)
- [Kotlin coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html)
 
### Android
-  [Jetpack compose](https://developer.android.com/jetpack/compose)
-  [Paging 3.0](https://developer.android.com/topic/libraries/architecture/paging/v3-overview)
-  [Jetpack compose navigation](https://developer.android.com/jetpack/compose/navigation?hl=es-419)
-  [Koin](https://insert-koin.io/)
-  [Coil](https://coil-kt.github.io/coil/compose/)
-  [Kotlin coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) and [Kotlion Flow](https://kotlinlang.org/docs/reference/coroutines/flow.html)

### iOS
- [SwiftUI](https://developer.apple.com/xcode/swiftui/)
- [AsyncImage](https://developer.apple.com/documentation/swiftui/asyncimage)
- [Combine](https://developer.apple.com/documentation/combine)

## Setup

### Android
Marvel developers: https://developer.marvel.com/

Add in the local.properties file the following variables **marvelPrivateKey** and **marvelPublicKey** with the keys obtained in the marvel api portal and then configure add the following code in the build.gradle.kts of the androidApp module:

 ``` kotlin
 
val publicKey: String = gradleLocalProperties(rootDir).getProperty("marvelPublicKey")
val privateKey: String = gradleLocalProperties(rootDir).getProperty("marvelPrivateKey")

android {

  defaultConfig {
    ...

    //keys
    buildConfigField("String", "PUBLIC_KEY", publicKey)
    buildConfigField("String", "PRIVATE_KEY", privateKey)
  }
  ...
 }
    
 ```
### iOS

Add in the Credentials.plist file the following variables marvelPrivateKey and marvelPublicKey with the keys obtained in the marvel api portal.

## Referencias

- [Kotlin Mobile Multiplaform Official site](https://kotlinlang.org/lp/mobile/)
