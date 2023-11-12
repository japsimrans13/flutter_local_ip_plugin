# Local IP Plugin

This Flutter plugin provides the functionality to retrieve the local IP address of the device. It's designed to work seamlessly with Android devices, offering an easy-to-use Dart interface for fetching the local IP.

## Features

- Retrieve the local IP address of an Android device.
- Simple and easy-to-use Dart interface.
- Ideal for network-related applications in Flutter.

## Getting Started

To use this plugin, add `local_ip_plugin` as a dependency in your `pubspec.yaml` file. Ensure you have the latest version by checking [local_ip_plugin on pub.dev](https://pub.dev/packages/local_ip_plugin).

```yaml
dependencies:
  local_ip_plugin: ^latest_version
```

## Ussage
Here's a quick example to show you how to use the plugin:
```
import 'package:local_ip_plugin/local_ip_plugin.dart';

void getLocalIP() async {
  String localIP = await LocalIpPlugin.getLocalIP();
  print('My local IP: $localIP');
}
```


## Additional Information
I appreciate every PR, so feel free to contribute. I will also look through all the issues on github and try to fix them as soon as possible.

