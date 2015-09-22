package com.jupiter.mumscrum.util;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.jupiter.mumscrum.entity.Coordinates;
import com.jupiter.mumscrum.entity.ReleaseBacklog;

public class Utility {

	public static String generateJSON(List<ReleaseBacklog> releases) {
		JSONObject object = new JSONObject();
		JSONArray array = new JSONArray();
		try {
			object.put("Releases", releases);
			array.put(object);
		} catch (JSONException e) {
			e.printStackTrace();
		}	
		
		return array.toString();
	}
	
	public static String generateDataSetJSON(List<Coordinates> coordinates) {
		JSONObject object = new JSONObject();
		JSONArray array = new JSONArray();
		try {
			object.put("Coordinates", coordinates);
			array.put(object);
		} catch (JSONException e) {
			e.printStackTrace();
		}	
		
		return array.toString();
	}
}
