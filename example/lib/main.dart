import 'package:flutter/material.dart';
import 'package:local_ip_plugin/local_ip_plugin.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatefulWidget {
  const MyApp({super.key});

  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  // Retrieves the local IP address.
  String _localIP = 'Unknown';

  @override
  void initState() {
    super.initState();
    _getLocalIP();
  }

  _getLocalIP() async {
    String localIP = await LocalIpPlugin.getLocalIP();
    setState(() {
      _localIP = localIP;
    });
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Local IP Plugin example app'),
        ),
        body: Center(
          child: Text('Local IP: $_localIP\n'),
        ),
      ),
    );
  }
}
