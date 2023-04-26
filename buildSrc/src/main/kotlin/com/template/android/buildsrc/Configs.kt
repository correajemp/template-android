package com.template.android.buildsrc

object Configs {
    const val namespace = "com.template.android"
    const val compileSdk = 33
    const val applicationId = "com.template.android"
    const val minSdk = 23
    const val targetSdk = 33
    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    const val dimension = "environment"

    object Develop {
        const val dimension = Configs.dimension
        const val applicationIdSuffix = ".develop"
        const val versionCode = 1
        const val versionName = "1.0.0"
    }

    object Staging {
        const val dimension = Configs.dimension
        const val applicationIdSuffix = ".staging"
        const val versionCode = 1
        const val versionName = "1.0.0"
    }

    object Production {
        const val dimension = Configs.dimension
        const val versionCode = 1
        const val versionName = "1.0.0"
    }
}