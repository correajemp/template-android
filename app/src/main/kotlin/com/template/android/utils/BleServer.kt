package com.template.android.utils

import android.annotation.SuppressLint
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothGattCharacteristic
import android.bluetooth.BluetoothGattServer
import android.bluetooth.BluetoothGattServerCallback
import android.bluetooth.BluetoothGattService
import android.bluetooth.BluetoothManager
import android.bluetooth.BluetoothProfile
import android.content.Context
import android.util.Log
import java.util.UUID

@SuppressLint("MissingPermission")
class BleServer(
    private val context: Context
) {

    private var bluetoothManager: BluetoothManager? = null
    private var bluetoothGattServer: BluetoothGattServer? = null

    private val uuid = "0000XXXX-0000-1000-8000-00805f9b34fb"

    private val gattServerCallback = object : BluetoothGattServerCallback() {
        override fun onConnectionStateChange(
            device: BluetoothDevice,
            status: Int,
            newState: Int
        ) {
            super.onConnectionStateChange(device, status, newState)
            Log.d("BleServer", "device --> $device")
            Log.d("BleServer", "status --> $status")
            Log.d("BleServer", "newState --> $newState")
            if (newState == BluetoothProfile.STATE_CONNECTED) {
                Log.d("BleServer", "newState --> connected")
                return
            }
            if (newState == BluetoothProfile.STATE_DISCONNECTED) {
                Log.d("BleServer", "newState --> disconnected")
                return
            }
        }

        override fun onCharacteristicReadRequest(
            device: BluetoothDevice,
            requestId: Int,
            offset: Int,
            characteristic: BluetoothGattCharacteristic
        ) {
            super.onCharacteristicReadRequest(device, requestId, offset, characteristic)
            Log.d("BleServer", "device --> $device")
            Log.d("BleServer", "requestId --> $requestId")
            Log.d("BleServer", "offset --> $offset")
            Log.d("BleServer", "characteristic --> $characteristic")
        }
    }

    fun startGattServer() {
        bluetoothManager = context.getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
        bluetoothGattServer = bluetoothManager?.openGattServer(context, gattServerCallback)
        val serviceUuid = UUID.fromString(uuid)
        val service = BluetoothGattService(serviceUuid, BluetoothGattService.SERVICE_TYPE_PRIMARY)
        bluetoothGattServer?.addService(service)
    }

    fun stopGattServer() {
        bluetoothGattServer?.close()
    }
}