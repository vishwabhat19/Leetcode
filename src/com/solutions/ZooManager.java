package com.solutions;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ZooManager {
	
	private Map<String, Object> foodData = new ConcurrentHashMap<String, Object>();
	
	public void put(String key, String value) {
		foodData.put(key, value);
	}
	
	public Object get(String key) {
		return foodData.get(key);
	}

	public static void main(String[] args) {
		Map<String, Object> map = new ConcurrentHashMap<String, Object>();
		map.put("penguin", 1);
		map.put("flamino", 2);
		for(String key : map.keySet()) {
			map.remove(key);
		}

	}

}
