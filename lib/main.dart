import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

void main() {
  runApp(const MainApp());
}

class MainApp extends StatefulWidget {
  const MainApp({super.key});

  @override
  State<MainApp> createState() => _MainAppState();
}

class _MainAppState extends State<MainApp> {
  var dev = const MethodChannel("flutterToastExample");
  var img = const MethodChannel("flutterImage");
  String? imgData;
  showMethod() async {
    // dev.invokeMethod("showToast",
    //     {"message": "Sunil sir i had called toast from native code"});
    dev.invokeMethod("showToast", "calling string");
    final i = await img.invokeMethod("image");
    setState(() {
      imgData = i;
    });
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        backgroundColor: Colors.teal,
        body: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Center(
              child: ElevatedButton(
                  onPressed: showMethod, child: const Text("show toast")),
            ),
            Center(
              child: Text(imgData.toString()),
            )
          ],
        ),
      ),
    );
  }
}
