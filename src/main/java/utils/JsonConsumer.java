package utils;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import streamtask.models.FamilyExpand;
import streamtask.models.PersonExpand;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class JsonConsumer {

    private static JsonObject readJson(String name) {
        try {
            JsonReader reader = new JsonReader(new FileReader("./src/main/resources/" + name));
            return new Gson().fromJson(reader, JsonObject.class);
        } catch (FileNotFoundException | JsonIOException | JsonSyntaxException e) {
            return null;
        }
    }

    public static FamilyExpand getFamily(String fileName) {
        Function<JsonElement, PersonExpand> getMember = object -> new Gson()
                .fromJson(object, PersonExpand.class);
        JsonArray familyMembersArray = Optional.ofNullable(readJson(fileName)
                .getAsJsonArray("family")).orElse(new JsonArray());
        var membersList = new ArrayList<JsonElement>();
        for (int i = 0; i < familyMembersArray.size(); i++) {
            membersList.add(familyMembersArray.get(i));
        }
        return new FamilyExpand(membersList.stream().map(element -> getMember.apply(element))
                .collect(Collectors.toList()));
    }
}
