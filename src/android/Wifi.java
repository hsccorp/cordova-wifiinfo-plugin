package org.apache.cordova.android;

import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URL;
import java.util.Collections;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;

import android.content.Context;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.content.Intent;
import android.content.IntentFilter;
import android.provider.Settings;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;



public class Wifi extends CordovaPlugin {

    public Wifi() {

    }

    public boolean execute(String action, JSONArray args,
            CallbackContext callbackContext) {
        JSONObject r = new JSONObject();
        try {

          if (action.equals("getWifiInfo")) {
                JSONObject wifi = getWifiInfo();
                callbackContext.success(wifi);
                return true;
            }
        else{
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Only alert and confirm are async.
        callbackContext.success(r);
        return true;
    }

 
    private String formatIP(int ip) {
        return String.format("%d.%d.%d.%d", (ip & 0xff), (ip >> 8 & 0xff),
                (ip >> 16 & 0xff), (ip >> 24 & 0xff));
    }


    private JSONObject getWifiInfo() {
        WifiManager wifiManager = (WifiManager) cordova.getActivity()
                .getSystemService(Context.WIFI_SERVICE);
        JSONObject wifiData = new JSONObject();
        WifiInfo wifi = wifiManager.getConnectionInfo();
        try {
            wifiData.put("MacAddress", wifi.getMacAddress());
            wifiData.put("BSSID", wifi.getBSSID());
            wifiData.put("HiddenSSID", wifi.getHiddenSSID());
            wifiData.put("IpAddress", formatIP(wifi.getIpAddress()));
            wifiData.put("LinkSpeed", wifi.getLinkSpeed());
            wifiData.put("NetworkId", wifi.getNetworkId());
            wifiData.put("Rssi", wifi.getRssi());
            wifiData.put("SSID", wifi.getSSID());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return wifiData;
    }

   
   

}