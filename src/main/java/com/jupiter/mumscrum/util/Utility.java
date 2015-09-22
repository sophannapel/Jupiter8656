package com.jupiter.mumscrum.util;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.jupiter.mumscrum.entity.ReleaseBacklog;
import com.jupiter.mumscrum.entity.Sprint;

public class Utility {

	public static  String generateJSON(List<ReleaseBacklog> list) {
		JSONObject object = new JSONObject();
		JSONArray array = new JSONArray();
		try {
			object.put("Releases", list);
			array.put(object);
		} catch (JSONException e) {
			e.printStackTrace();
		}	
		
		return array.toString();
	}
	
	public static <T> String generateJSONInGeneric(List<T> list) {
		JSONObject object = new JSONObject();
		JSONArray array = new JSONArray();
		try {
			object.put("resultList", list);
			array.put(object);
		} catch (JSONException e) {
			e.printStackTrace();
		}	
		
		return array.toString();
	}
}
