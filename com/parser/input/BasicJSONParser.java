package com.parser.input;

import org.json.JSONArray;
import org.json.JSONObject;


public class BasicJSONParser {
	
	static String json = "...";

	public void readFromJSON(String filename) {
		JSONObject obj = new JSONObject(json);
        String pageName = obj.getJSONObject("pageInfo").getString("pageName");

        System.out.println(pageName);

        JSONArray arr = obj.getJSONArray("posts");
        for (int i = 0; i < arr.length(); i++) {
            String post_id = arr.getJSONObject(i).getString("post_id");
            System.out.println(post_id);
        }
	}
}
