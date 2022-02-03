package utils;

import java.util.Objects;

public class ConfigReader {

    public static String getConfigStat(String name) {
       return Objects.requireNonNull(JsonParser.readJson("config.json")).get(name).getAsString();
    }
}
