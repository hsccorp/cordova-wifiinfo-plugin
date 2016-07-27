# cordova-wifiinfo-plugin
Cordova plugin based on android.net.WifiInfo, retrives wifiInfo like link speed SSID etc.



## Installation

> cordova plugin add cordova-wifiinfo-plugin

## Usage
```js
 function success(results) {
            console.log(JSON.stringify(results));
          };
  function err(e) {
            console.log(JSON.stringify(e));
          };
 
 WifiInfo.getWifiInfo(success,err);
 ```
 
 ## Response
 
 ```json
 {
	MacAddress: "xx:xx:xx:xx:xx:xx",
	BSSID: "xx:xx:xx:xx:xx:xx",
	HiddenSSID: false,
	IpAddress: "x.x.x.x",
  LinkSpeed: 72,
	NetworkId: 5,
	Rssi: -40,
	SSID: "\"xxx_xxx\""
}
 ```

