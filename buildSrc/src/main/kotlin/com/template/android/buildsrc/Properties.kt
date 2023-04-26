package com.template.android.buildsrc

import java.io.File
import java.io.FileInputStream

object Properties {
    private val keystoreProperties by lazy {
        java.util.Properties().apply {
            load(FileInputStream(File("keystore.properties")))
        }
    }

    fun getKeystoreValue(key: String): String {
        return keystoreProperties.getProperty(key)
    }

    val commonProperties by lazy {
        java.util.Properties().apply {
            load(FileInputStream(File("configs/common.properties")))
        }
    }

    val developProperties by lazy {
        java.util.Properties().apply {
            load(FileInputStream(File("configs/develop.properties")))
        }
    }

    val stagingProperties by lazy {
        java.util.Properties().apply {
            load(FileInputStream(File("configs/staging.properties")))
        }
    }

    val productionProperties by lazy {
        java.util.Properties().apply {
            load(FileInputStream(File("configs/production.properties")))
        }
    }
}