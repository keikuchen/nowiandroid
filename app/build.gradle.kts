plugins {
    kotlin("android")
    id("com.android.application")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "keikuchen.nowiandroid"
    compileSdk = 33

    defaultConfig {
        applicationId = "keikuchen.nowiandroid"
        minSdk = 30
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.0"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(libs.bundles.base)

    // accompanist
    implementation(libs.bundles.accompanist.pager)

    // compose
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.bundles.compose)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.bundles.compose.androidtest)
    debugImplementation(libs.bundles.compose.debug)

    // hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.kapt)

    implementation(libs.timber)

    androidTestImplementation(libs.bundles.androidtest)
    testImplementation(libs.bundles.test)
}
