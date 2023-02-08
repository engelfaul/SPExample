package starter.utils;

import com.google.gson.Gson;

import java.util.Map;

public class RestUtils {

    public static Map convertJsonMap(String object) {
        final Gson gson = new Gson();
        return gson.fromJson(object, Map.class);
    }
}
