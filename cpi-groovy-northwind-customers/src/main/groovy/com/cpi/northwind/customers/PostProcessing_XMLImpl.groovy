package com.cpi.northwind.customers

import com.sap.gateway.ip.core.customdev.util.Message
import groovy.json.JsonOutput
import groovy.json.JsonSlurper


static Message postProcessing_XML(Message message) {
    Map<String, Object> headers = message.getHeaders();
    String xAccept = headers.get("x-accept");

    if (xAccept != 'application/xml') {
        return message;
    }

    Map<String, String> jsonMap = readPayloadToMap(message.getBody(String)) as Map;
    jsonMap = removeKey(jsonMap, "@odata.context");

    String json = JsonOutput.toJson(jsonMap);
    message.setBody(json);

    return message;
}


/**
 *
 * @param payload
 * @return
 */
private static Map readPayloadToMap(String payload) {
    def jsonSlurper = new JsonSlurper();
    return jsonSlurper.parseText(payload) as Map;
}

/**
 *
 * @param map
 * @param key
 * @return
 */
private static removeKey(Map<String, String> map, String key) {
    map.remove(key);
    return map;
}
