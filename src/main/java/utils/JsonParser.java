package utils;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JsonParser {

    public static JsonObject readJson(String fileName) {
        try {
            JsonReader reader = new JsonReader(new FileReader("./src/main/resources/" + fileName));
            return new Gson().fromJson(reader, JsonObject.class);
        } catch (FileNotFoundException | JsonIOException | JsonSyntaxException e) {
            return null;
        }
    }
}
