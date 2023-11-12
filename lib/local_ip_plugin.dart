library local_ip;

import 'dart:async';
import 'dart:io';
import 'package:flutter/services.dart';

class LocalIpPlugin {
  static const MethodChannel _channel = MethodChannel('local_ip');

  // Retrieves the local IP address.
  static Future<String> getLocalIP() async {
    // For Now only Android is supported
    if (Platform.isAndroid) {
      final String localIP = await _channel.invokeMethod('getLocalIP');
      return localIP;
    } else {
      return "Platform not supported";
    }
  }
}
