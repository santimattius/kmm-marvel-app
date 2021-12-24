plugins {
    id("com.android.application")
    kotlin("android")
}

dependencies {
    val kotlinVersion = "1.5.31"

    val coreKtxVersion = "1.6.0"
    val appcompatVersion = "1.3.1"
    val materialVersion = "1.4.0"
    val activityComposeVersion = "1.3.1"

    implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")

    implementation ("androidx.core:core-ktx:$coreKtxVersion")
    implementation ("androidx.appcompat:appcompat:$appcompatVersion")
    implementation ("com.google.android.material:material:$materialVersion")

    // Compose
    val composeVersion = "1.0.5"
    implementation ("androidx.compose.ui:ui:$composeVersion")
    implementation ("androidx.compose.material:material:$composeVersion")
    implementation ("androidx.compose.ui:ui-tooling-preview:$composeVersion")
    implementation ("androidx.compose.material:material-icons-extended:$composeVersion")
    implementation ("androidx.compose.runtime:runtime-livedata:$composeVersion")
    implementation ("androidx.activity:activity-compose:$activityComposeVersion")
    debugImplementation ("androidx.compose.ui:ui-tooling:$composeVersion")
    androidTestImplementation ("androidx.compose.ui:ui-test-junit4:$composeVersion")

    // ViewModel and LiveData
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.4.0")

    val koinVersion = "3.1.3"
    implementation("io.insert-koin:koin-android:$koinVersion")
    implementation ("io.insert-koin:koin-androidx-compose:$koinVersion")

    //Navigation
    implementation ("androidx.navigation:navigation-compose:2.4.0-rc01")
    // Paging Compose
    implementation("androidx.paging:paging-compose:1.0.0-alpha14")

    //Coil Compose
    val coilComposeVersion = "1.3.2"
    implementation ("io.coil-kt:coil-compose:$coilComposeVersion")

    //Accompanist
    val accompanistVersion = "0.20.3"
    implementation ("com.google.accompanist:accompanist-navigation-animation:$accompanistVersion")
    implementation ("com.google.accompanist:accompanist-swiperefresh:$accompanistVersion")

    implementation(project(":shared"))
}

android {
    compileSdk = 31
    defaultConfig {
        applicationId = "com.santimattius.kmm.marvel.android"
        minSdk = 23
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.0.5"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

