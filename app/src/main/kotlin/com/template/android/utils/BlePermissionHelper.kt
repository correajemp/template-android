package com.template.android.utils

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat

object BlePermissionHelper {

    fun requestPermissionSdk28(
        context: Context,
        hasPermissionCallback: () -> Unit,
        requestPermissionsLauncherCallback: () -> Unit
    ) {
        val bluetoothPermission = ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.BLUETOOTH
        )
        val bluetoothAdminPermission = ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.BLUETOOTH_ADMIN
        )
        val findLocationPermission = ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_FINE_LOCATION
        )
        val coarseLocationPermission = ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )
        val hasPermission = (bluetoothPermission == PackageManager.PERMISSION_GRANTED &&
                bluetoothAdminPermission == PackageManager.PERMISSION_GRANTED &&
                findLocationPermission == PackageManager.PERMISSION_GRANTED &&
                coarseLocationPermission == PackageManager.PERMISSION_GRANTED)

        if (hasPermission) {
            hasPermissionCallback()
            return
        }

        requestPermissionsLauncherCallback()
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    fun requestPermissionSdk29(
        context: Context,
        hasPermissionCallback: () -> Unit,
        requestPermissionsLauncherCallback: () -> Unit
    ) {
        val bluetoothPermission = ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.BLUETOOTH
        )
        val bluetoothAdminPermission = ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.BLUETOOTH_ADMIN
        )
        val findLocationPermission = ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_FINE_LOCATION
        )
        val coarseLocationPermission = ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )
        val backgroundLocationPermission = ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_BACKGROUND_LOCATION
        )
        val hasPermission = (bluetoothPermission == PackageManager.PERMISSION_GRANTED &&
                bluetoothAdminPermission == PackageManager.PERMISSION_GRANTED &&
                findLocationPermission == PackageManager.PERMISSION_GRANTED &&
                coarseLocationPermission == PackageManager.PERMISSION_GRANTED &&
                backgroundLocationPermission == PackageManager.PERMISSION_GRANTED)

        if (hasPermission) {
            hasPermissionCallback()
            return
        }

        requestPermissionsLauncherCallback()
    }

    @RequiresApi(Build.VERSION_CODES.S)
    fun requestPermissionSdk31(
        context: Context,
        hasPermissionCallback: () -> Unit,
        requestPermissionsLauncherCallback: () -> Unit
    ) {
        val bluetoothPermission = ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.BLUETOOTH
        )
        val bluetoothAdminPermission = ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.BLUETOOTH_ADMIN
        )
        val bluetoothConnectPermission = ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.BLUETOOTH_CONNECT
        )
        val bluetoothScanPermission = ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.BLUETOOTH_SCAN
        )
        val findLocationPermission = ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_FINE_LOCATION
        )
        val coarseLocationPermission = ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )
        val backgroundLocationPermission = ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_BACKGROUND_LOCATION
        )
        val hasPermission = (bluetoothPermission == PackageManager.PERMISSION_GRANTED &&
                bluetoothAdminPermission == PackageManager.PERMISSION_GRANTED &&
                bluetoothConnectPermission == PackageManager.PERMISSION_GRANTED &&
                bluetoothScanPermission == PackageManager.PERMISSION_GRANTED &&
                findLocationPermission == PackageManager.PERMISSION_GRANTED &&
                coarseLocationPermission == PackageManager.PERMISSION_GRANTED &&
                backgroundLocationPermission == PackageManager.PERMISSION_GRANTED)

        if (hasPermission) {
            hasPermissionCallback()
            return
        }

        requestPermissionsLauncherCallback()
    }

}