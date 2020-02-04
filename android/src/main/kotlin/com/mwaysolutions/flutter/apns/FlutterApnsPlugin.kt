package com.mwaysolutions.flutter.apns

import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result
import io.flutter.plugin.common.PluginRegistry.Registrar

/** FlutterApnsPlugin  */
class FlutterApnsPlugin : MethodCallHandler {

    @Override
    fun onMethodCall(call: MethodCall, result: Result) {
        if (call.method.equals("getPlatformVersion")) {
            result.success("Android " + android.os.Build.VERSION.RELEASE)
        } else {
            result.notImplemented()
        }
    }

    companion object {
        /** Plugin registration.  */
        fun registerWith(registrar: Registrar) {
            val channel = MethodChannel(registrar.messenger(), "flutter_apns")
            channel.setMethodCallHandler(FlutterApnsPlugin())
        }
    }
}
