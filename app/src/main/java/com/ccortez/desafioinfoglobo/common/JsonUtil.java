package com.ccortez.desafioinfoglobo.common;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Cristiano Cortez
 */

public class JsonUtil {

    private String TAG = "JsonUtil";

    public static String getSync(InputStream inputStream){
        try{
            JsonParser parser = new JsonParser();
            JsonElement jsonElement =  parser.parse(new InputStreamReader(inputStream));
            JsonObject jsonObject = jsonElement.getAsJsonObject();

            return jsonObject.toString();
        }catch (Exception e){
            return null;
        }
    }

    public String getNodeFilter(String json){
        try{
            JsonParser parser = new JsonParser();
            JsonElement jsonElement =  parser.parse(json);
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            return jsonObject.toString();
        }catch (Exception e){
            return null;
        }

    }

    public JSONObject getObjectFromString(String json){
        try{
            JsonParser parser = new JsonParser();
            JsonElement jsonElement =  parser.parse(json);
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            return new Gson().fromJson(jsonObject.toString(), JSONObject.class);
        }catch (Exception e){
            return null;
        }

    }

    public static Integer getAgeFromDate(Date bornDate){
        if (bornDate ==null) {
            return 0;
        }

        Calendar born = Calendar.getInstance();
        Calendar today = Calendar.getInstance();
        born.setTime(bornDate);

        int age = today.get(Calendar.YEAR) - born.get(Calendar.YEAR);

        if (today.get(Calendar.DAY_OF_YEAR) < born.get(Calendar.DAY_OF_YEAR)){
            age--;
        }
        return age;

    }

    public static Date getDateFromAge(Integer age){
        Calendar born = Calendar.getInstance();
        Calendar today = Calendar.getInstance();

        Integer year = today.get(Calendar.YEAR) + age;

        born.set(Calendar.YEAR, year);
        return born.getTime();
    }

    public static String getDateFormated(Date date, String format) {
        if (format == null) {
            format = "yyyy-MM-dd";
        }

        if (date != null) {
            android.text.format.DateFormat df = new android.text.format.DateFormat();
            return df.format(format, date).toString();
        }

        return null;
    }
}
