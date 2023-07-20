package com.example.naive_example

import android.annotation.SuppressLint
import android.widget.Toast
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel


class MainActivity: FlutterActivity() {
    private val channelName = "flutterToastExample";
    private val channel2 = "flutterImage"

    @SuppressLint("SuspiciousIndentation")
    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        val channel = MethodChannel(flutterEngine.dartExecutor.binaryMessenger,channelName);
        var imageChannel = MethodChannel(flutterEngine.dartExecutor.binaryMessenger,channel2);
//        channel.setMethodCallHandler(BroadCastHandler())
            channel.setMethodCallHandler { call, result ->
                if(call.method == "showToast"){
                    Toast.makeText(this,"Toast is called",Toast.LENGTH_LONG).show();
                }
            }
//        Pass string argument from the native chaneel
        imageChannel.setMethodCallHandler { call, result ->

            if(call.method == "image"){
                result.success("images called");
            }
        }
    }
}
