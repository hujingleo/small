package com.ptteng.small.admin.util;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.ptteng.small.admin.gsonbean.StorageGsonBean;

/**
 * 尝试封装，但没成功
 * 
 * @author liut
 *
 */
public class GsonUtil2 {
  
  
  private GsonUtil2() {
  }
  
  
  public static List<StorageGsonBean> fromStorageGsonBeanJson(String listJson) {
    Gson gson = new GsonBuilder().create();
    List<StorageGsonBean> list = gson.fromJson(listJson, new TypeToken<ArrayList<StorageGsonBean>>() {
    }.getType());
    return list;
  }
  
  public static String jsonFormatter(String uglyJSONString) {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    JsonParser jp = new JsonParser();
    JsonElement je = jp.parse(uglyJSONString);
    return gson.toJson(je);
  }
}
