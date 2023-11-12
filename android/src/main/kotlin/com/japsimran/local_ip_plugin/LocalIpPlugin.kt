package com.japsimran.local_ip_plugin

import androidx.annotation.NonNull
import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result
import java.net.InetAddress
import io.flutter.embedding.engine.FlutterEngine
import java.net.NetworkInterface
import java.util.Collections

/** LocalIpPlugin */
class LocalIpPlugin: FlutterPlugin, MethodCallHandler {
  private lateinit var channel : MethodChannel

  override fun onAttachedToEngine(@NonNull flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
    channel = MethodChannel(flutterPluginBinding.binaryMessenger, "local_ip")
    channel.setMethodCallHandler(this)
  }

  override fun onMethodCall(@NonNull call: MethodCall, @NonNull result: Result) {
    if (call.method == "getLocalIP") {
      val localIP = getLocalIpAddress()
      result.success(localIP)
    } else {
      result.notImplemented()
    }
  }

  override fun onDetachedFromEngine(@NonNull binding: FlutterPlugin.FlutterPluginBinding) {
    channel.setMethodCallHandler(null)
  }

  private fun getLocalIpAddress(): String {
    val interfaces = Collections.list(NetworkInterface.getNetworkInterfaces())
    for (intf in interfaces) {
        val addrs = Collections.list(intf.inetAddresses)
        for (addr in addrs) {
            // Check if the address is not a loopback address and is IPv4
            if (!addr.isLoopbackAddress && addr is InetAddress) {
                val sAddr = addr.hostAddress
                val isIPv4 = sAddr.indexOf(':') < 0
                if (isIPv4) {
                    return sAddr
                }
            }
        }
    }
    return "Unable to determine IP Address"
}
}
