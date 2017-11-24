package com.mhf.common.base.pulisher.template;

import java.util.HashMap;
import java.util.Map;

public class BusinessEventTemplate {

    private Map<String, Object> map = new HashMap<String, Object>();

    public Object get(String key) {
        return map.get(key);
    }

    public BusinessEventTemplate put(String key, Object value) {
        map.put(key, value);
        return this;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
}
