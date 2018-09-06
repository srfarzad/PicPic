package com.picpic.Utils;

import com.picpic.models.Images;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonParser {

    public static List<Images> getImagesList(String response) throws Exception {
        List<Images> imagesList = new ArrayList<>();
        JSONArray jsonArray = new JSONArray(response);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            Images images = new Images();
            images.setImage(jsonObject.getString("img"));
            imagesList.add(images);
        }
        return imagesList;

    }

}
