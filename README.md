# KMM Marvel App

Application using Kotlin mobile multi platform and Marvel API.

## Screenshots
<p align="center">
  <img src="image?raw=true" alt="App Capture"/>
</p>


## Application architecture

In the following images you will see how the app is built and what its levels of abstraction are.

### General

<p align="center">
  <img src="https://github.com/santimattius/android-arch-template/blob/master/screenshoot/android-clean-arch-general.png?raw=true" alt="general architecture"/>
</p>

### Project structure

<p align="left">
  <img src="image?raw=true" alt="Project packages"/>
</p>

## Dependencies

Below you will find the libraries used to build the template and according to my criteria the most used in android development so far.

### Shared

### Android
- [Dependencia]()
- [Dependencia]()
- [Dependencia]()
- [Dependencia]()

### iOS
- [Dependencia]()
- [Dependencia]()
- [Dependencia]()
- [Dependencia]()
- [Dependencia]()

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

## Referencias

- [Referencia]()
- [Referencia]()
- [Referencia]()
- [Referencia]()
