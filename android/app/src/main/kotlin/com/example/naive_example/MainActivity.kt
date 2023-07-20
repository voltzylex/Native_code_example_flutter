package com.example.naive_example

import android.widget.Toast
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel


class MainActivity: FlutterActivity() {
    private val channelName = "flutterToastExample";

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        val channel = MethodChannel(flutterEngine.dartExecutor.binaryMessenger,channelName);
//        channel.setMethodCallHandler(BroadCastHandler())
            channel.setMethodCallHandler { call, result ->
                if(call.method == "showToast"){
                    Toast.makeText(this,"Toast is called",Toast.LENGTH_LONG).show();
                }
            }
    }
}
