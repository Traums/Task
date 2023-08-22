package example3;

import example1.Hero;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class JsonConverter {
    public static String heroToJson(Hero hero){
        String jsonString = new JSONObject().put("hero",new JSONObject()
                                                .put("id",String.valueOf(hero.getId()))
                                                .put("name",hero.getName())
                                                .put("lvl",String.valueOf(hero.getLevel())))
                                                .toString();
        return jsonString;
    }
}
