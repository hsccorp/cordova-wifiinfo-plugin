
/**
 * Get Wifi info
 *
 * @param {Function} successCallback The function to call when the heading data is available
 * @param {Function} errorCallback The function to call when there is an error getting the heading data. (OPTIONAL)
 */

var WifiInfo=function() {
};
WifiInfo.getWifiInfo = function(success, fail) {
    cordova.exec(success, fail, "WifiInfo", "getWifiInfo", []);
};

module.exports = WifiInfo;


