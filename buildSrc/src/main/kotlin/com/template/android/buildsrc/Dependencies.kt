package com.template.android.buildsrc

object Dependencies {
    object Default {
        const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
        const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
        const val material = "com.google.android.material:material:${Versions.material}"
        const val lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleRuntimeKtx}"
        const val navigationRuntimeKtx = "androidx.navigation:navigation-runtime-ktx:${Versions.navigationRuntimeKtx}"
        const val kotlinxCoroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinxCoroutinesCore}"
    }

    object Compose {
        const val ui = "androidx.compose.ui:ui:${Versions.compose}"
        const val activity = "androidx.activity:activity-compose:$${Versions.compose}"
        const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.lifecycleViewModelCompose}"
        const val material = "androidx.compose.material:material:${Versions.compose}"
        const val materialIconsExtended = "androidx.compose.material:material-icons-extended:${Versions.compose}"
        const val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
        const val uiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
        const val uiTestManifest = "androidx.compose.ui:ui-test-manifest:${Versions.compose}"
        const val uiTestJunit4 = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"
    }

    object DaggerHilt {
        const val android = "com.google.dagger:hilt-android:${Versions.hiltAndroid}"
        const val androidCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hiltAndroid}"
        const val lifecycleViewModel = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hiltLifecycleViewModel}"
        const val compiler = "androidx.hilt:hilt-compiler:${Versions.hiltCompiler}"
        const val navigationCompose = "androidx.hilt:hilt-navigation-compose:${Versions.hiltNavigationCompose}"
    }

    object Room {
        const val runtime = "androidx.room:room-runtime:${Versions.room}"
        const val compiler = "androidx.room:room-compiler:${Versions.room}"
        const val ktx = "androidx.room:room-ktx:${Versions.room}"
    }

    object DataStore {
        const val core = "androidx.datastore:datastore-core:${Versions.dataStore}"
        const val preferences = "androidx.datastore:datastore-preferences:${Versions.dataStore}"
    }

    object Network {
        object NetworkResponseAdapter {
            const val networkResponseAdapter = "com.github.haroldadmin:NetworkResponseAdapter:${Versions.networkResponseAdapter}"
        }

        object Retrofit {
            const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
            const val adapterRxJava2 = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
            const val converterGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
        }

        object Stetho {
            const val stetho = "com.facebook.stetho:stetho:${Versions.stetho}"
            const val stethoOkhttp3 = "com.facebook.stetho:stetho-okhttp3:${Versions.stetho}"
        }
    }

    object Worker {
        const val runtimeKtx = "androidx.work:work-runtime-ktx:${Versions.workRuntimeKtx}"
        const val hilt = "androidx.hilt:hilt-work:${Versions.hiltWork}"
        const val hiltCompiler = "androidx.hilt:hilt-compiler:${Versions.hiltCompiler}"
    }

    object UnitTest {
        const val junit = "junit:junit:${Versions.junit}"
        const val junitExt = "androidx.test.ext:junit:${Versions.junitExt}"
        const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    }

    object FireCrasher {
        const val fireCrasher = "com.github.osama-raddad:FireCrasher:${Versions.fireCrasher}"
    }

    object DesugarJdk {
        const val desugarJdk = "com.android.tools:desugar_jdk_libs:${Versions.desugarJdk}"
    }

    object Google {
        object Accompanist {
            const val systemUiController = "com.google.accompanist:accompanist-systemuicontroller:${Versions.accompanist}"
            const val themeAdapterAppcompat = "com.google.accompanist:accompanist-themeadapter-appcompat:${Versions.accompanist}"
            const val themeAdapterMaterial = "com.google.accompanist:accompanist-themeadapter-material:${Versions.accompanist}"
            const val themeAdapterMaterial3 = "com.google.accompanist:accompanist-themeadapter-material3:${Versions.accompanist}"
            const val permissions = "com.google.accompanist:accompanist-permissions:${Versions.accompanist}"
            const val placeholder = "com.google.accompanist:accompanist-placeholder:${Versions.accompanist}"
            const val flowlayout = "com.google.accompanist:accompanist-flowlayout:${Versions.accompanist}"
            const val navigationAnimation = "com.google.accompanist:accompanist-navigation-animation:${Versions.accompanist}"
            const val drawablePainter = "com.google.accompanist:accompanist-drawablepainter:${Versions.accompanist}"
            const val adaptive = "com.google.accompanist:accompanist-adaptive:${Versions.accompanist}"
            const val testHarness = "com.google.accompanist:accompanist-testharness:${Versions.accompanist}"
            const val insets = "com.google.accompanist:accompanist-insets:${Versions.accompanist}"
            const val swipeRefresh = "com.google.accompanist:accompanist-swiperefresh:${Versions.accompanist}"
            const val appcompatTheme = "com.google.accompanist:accompanist-appcompat-theme:${Versions.accompanist}"
            const val pager = "com.google.accompanist:accompanist-pager:${Versions.accompanist}"
        }
    }
}