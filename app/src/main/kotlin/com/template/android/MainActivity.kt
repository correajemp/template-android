package com.template.android

import android.Manifest
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.result.contract.ActivityResultContracts
import com.template.android.utils.BleClient
import com.template.android.utils.BlePermissionHelper
import com.template.android.utils.BleServer

class MainActivity : ComponentActivity() {

    private val bleClient by lazy {
        BleClient(this)
    }

    private val bleServer by lazy {
        BleServer(this)
    }

    private val requestPermissionsLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            if (permissions[Manifest.permission.BLUETOOTH] == true &&
                permissions[Manifest.permission.BLUETOOTH_ADMIN] == true &&
                permissions[Manifest.permission.BLUETOOTH_CONNECT] == true &&
                permissions[Manifest.permission.BLUETOOTH_SCAN] == true &&
                permissions[Manifest.permission.ACCESS_FINE_LOCATION] == true &&
                permissions[Manifest.permission.ACCESS_COARSE_LOCATION] == true &&
                permissions[Manifest.permission.ACCESS_BACKGROUND_LOCATION] == true
            ) {
                bleClient.startScanAndConnect()
                bleServer.startGattServer()
            } else {
                Log.d("MainActivity", "Permission Denied")
            }
            return@registerForActivityResult
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            if (permissions[Manifest.permission.BLUETOOTH] == true &&
                permissions[Manifest.permission.BLUETOOTH_ADMIN] == true &&
                permissions[Manifest.permission.ACCESS_FINE_LOCATION] == true &&
                permissions[Manifest.permission.ACCESS_COARSE_LOCATION] == true &&
                permissions[Manifest.permission.ACCESS_BACKGROUND_LOCATION] == true
            ) {
                bleClient.startScanAndConnect()
                bleServer.startGattServer()
            } else {
                Log.d("MainActivity", "Permission Denied")
            }
            return@registerForActivityResult
        }

        if (permissions[Manifest.permission.BLUETOOTH] == true &&
            permissions[Manifest.permission.BLUETOOTH_ADMIN] == true &&
            permissions[Manifest.permission.ACCESS_FINE_LOCATION] == true &&
            permissions[Manifest.permission.ACCESS_COARSE_LOCATION] == true
        ) {
            bleClient.startScanAndConnect()
            bleServer.startGattServer()
        } else {
            Log.d("MainActivity", "Permission Denied")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            BlePermissionHelper.requestPermissionSdk31(
                context = this,
                hasPermissionCallback = {
                    bleClient.startScanAndConnect()
                    bleServer.startGattServer()
                },
                requestPermissionsLauncherCallback = {
                    requestPermissionsLauncher.launch(
                        arrayOf(
                            Manifest.permission.BLUETOOTH,
                            Manifest.permission.BLUETOOTH_ADMIN,
                            Manifest.permission.BLUETOOTH_CONNECT,
                            Manifest.permission.BLUETOOTH_SCAN,
                            Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_COARSE_LOCATION,
                            Manifest.permission.ACCESS_BACKGROUND_LOCATION
                        )
                    )
                }
            )
            return
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            BlePermissionHelper.requestPermissionSdk29(
                context = this,
                hasPermissionCallback = {
                    bleClient.startScanAndConnect()
                    bleServer.startGattServer()
                },
                requestPermissionsLauncherCallback = {
                    requestPermissionsLauncher.launch(
                        arrayOf(
                            Manifest.permission.BLUETOOTH,
                            Manifest.permission.BLUETOOTH_ADMIN,
                            Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_COARSE_LOCATION,
                            Manifest.permission.ACCESS_BACKGROUND_LOCATION
                        )
                    )
                }
            )
            return
        }

        BlePermissionHelper.requestPermissionSdk28(
            context = this,
            hasPermissionCallback = {
                bleClient.startScanAndConnect()
                bleServer.startGattServer()
            },
            requestPermissionsLauncherCallback = {
                requestPermissionsLauncher.launch(
                    arrayOf(
                        Manifest.permission.BLUETOOTH,
                        Manifest.permission.BLUETOOTH_ADMIN,
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                    )
                )
            }
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        bleClient.disconnect()
        bleServer.stopGattServer()
    }
}
