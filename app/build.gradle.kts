@file:Suppress("UnstableApiUsage")

import com.template.android.buildsrc.Configs
import com.template.android.buildsrc.Dependencies
import com.template.android.buildsrc.Properties
import com.template.android.buildsrc.Versions

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    id("org.jlleitschuh.gradle.ktlint")
    id("kotlin-parcelize")
    kotlin("kapt")
}

android {
    signingConfigs {
        create("release") {
            keyAlias = Properties.getKeystoreValue("KEY_ALIAS")
            keyPassword = Properties.getKeystoreValue("KEY_PASSWORD")
            storeFile = file(Properties.getKeystoreValue("STORE_FILE"))
            storePassword = Properties.getKeystoreValue("STORE_PASSWORD")
            enableV1Signing = true
            enableV2Signing = true
        }
    }
    namespace = Configs.applicationId
    compileSdk = Configs.compileSdk
    defaultConfig {
        applicationId = Configs.applicationId
        minSdk = Configs.minSdk
        targetSdk = Configs.targetSdk
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables.useSupportLibrary = true
        Properties.commonProperties.onEach { parameter ->
            buildConfigField(
                "String",
                parameter.key.toString(),
                parameter.value.toString()
            )
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("release")
        }
    }
    flavorDimensions.addAll(listOf(Configs.dimension))
    productFlavors {
        create("develop") {
            dimension = Configs.Develop.dimension
            applicationIdSuffix = Configs.Develop.applicationIdSuffix
            versionCode = Configs.Develop.versionCode
            versionName = Configs.Develop.versionName
            Properties.developProperties.onEach { parameter ->
                buildConfigField(
                    "String",
                    parameter.key.toString(),
                    parameter.value.toString()
                )
            }
        }
        create("staging") {
            dimension = Configs.Staging.dimension
            applicationIdSuffix = Configs.Staging.applicationIdSuffix
            versionCode = Configs.Staging.versionCode
            versionName = Configs.Staging.versionName
            Properties.stagingProperties.onEach { parameter ->
                buildConfigField(
                    "String",
                    parameter.key.toString(),
                    parameter.value.toString()
                )
            }
        }
        create("production") {
            dimension = Configs.Production.dimension
            versionCode = Configs.Production.versionCode
            versionName = Configs.Production.versionName
            Properties.productionProperties.onEach { parameter ->
                buildConfigField(
                    "String",
                    parameter.key.toString(),
                    parameter.value.toString()
                )
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
        isCoreLibraryDesugaringEnabled = true
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose
    }
    packaging {
        resources.excludes.add("META-INF/*")
    }
}

dependencies {
    // Default
    implementation(Dependencies.Default.coreKtx)
    implementation(Dependencies.Default.appCompat)
    implementation(Dependencies.Default.material)
    implementation(Dependencies.Default.lifecycleRuntimeKtx)
    implementation(Dependencies.Default.navigationRuntimeKtx)
    implementation(Dependencies.Default.kotlinxCoroutinesCore)

    // Compose
    implementation(Dependencies.Compose.ui)
    implementation(Dependencies.Compose.activity)
    implementation(Dependencies.Compose.lifecycleViewModel)
    implementation(Dependencies.Compose.material)
    implementation(Dependencies.Compose.materialIconsExtended)
    implementation(Dependencies.Compose.uiToolingPreview)
    debugImplementation(Dependencies.Compose.uiTooling)
    debugImplementation(Dependencies.Compose.uiTestManifest)
    androidTestImplementation(Dependencies.Compose.uiTestJunit4)

    // Dagger Hilt
    implementation(Dependencies.DaggerHilt.android)
    kapt(Dependencies.DaggerHilt.androidCompiler)
    kapt(Dependencies.DaggerHilt.compiler)
    implementation(Dependencies.DaggerHilt.navigationCompose)

    // Room
    implementation(Dependencies.Room.runtime)
    kapt(Dependencies.Room.compiler)
    implementation(Dependencies.Room.ktx)

    // Data Store
    implementation(Dependencies.DataStore.core)
    implementation(Dependencies.DataStore.preferences)

    // Network
    implementation(Dependencies.Network.NetworkResponseAdapter.networkResponseAdapter)
    implementation(Dependencies.Network.Retrofit.retrofit)
    implementation(Dependencies.Network.Retrofit.adapterRxJava2)
    implementation(Dependencies.Network.Retrofit.converterGson)
    implementation(Dependencies.Network.Stetho.stetho)
    implementation(Dependencies.Network.Stetho.stethoOkhttp3)

    // Work Manager
    implementation(Dependencies.Worker.runtimeKtx)
    implementation(Dependencies.Worker.hilt)
    kapt(Dependencies.Worker.hiltCompiler)

    // Unit Test
    testImplementation(Dependencies.UnitTest.junit)
    androidTestImplementation(Dependencies.UnitTest.junitExt)
    androidTestImplementation(Dependencies.UnitTest.espressoCore)

    // Fire Crasher
    implementation(Dependencies.FireCrasher.fireCrasher)

    // Desugaring Code
    coreLibraryDesugaring(Dependencies.DesugarJdk.desugarJdk)

    // Accompanist
    implementation(Dependencies.Google.Accompanist.systemUiController)
    implementation(Dependencies.Google.Accompanist.themeAdapterAppcompat)
    implementation(Dependencies.Google.Accompanist.themeAdapterMaterial)
    implementation(Dependencies.Google.Accompanist.themeAdapterMaterial3)
    implementation(Dependencies.Google.Accompanist.permissions)
    implementation(Dependencies.Google.Accompanist.placeholder)
    implementation(Dependencies.Google.Accompanist.flowlayout)
    implementation(Dependencies.Google.Accompanist.navigationAnimation)
    implementation(Dependencies.Google.Accompanist.drawablePainter)
    implementation(Dependencies.Google.Accompanist.adaptive)
    implementation(Dependencies.Google.Accompanist.testHarness)
    implementation(Dependencies.Google.Accompanist.insets)
    implementation(Dependencies.Google.Accompanist.swipeRefresh)
    implementation(Dependencies.Google.Accompanist.appcompatTheme)
    implementation(Dependencies.Google.Accompanist.pager)
}

kapt {
    correctErrorTypes = true
}

hilt {
    enableAggregatingTask = true
}
