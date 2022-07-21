import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonParser {

    private static final Pattern REGEX_ITEMS = Pattern.compile(".*\\[(.+)\\].*");
    private static final Pattern REGEX_ATTRIBUTES_JSON = Pattern.compile("\"(.+?)\":\"(.*?)\"");

    public List<Map<String, String>> parse(String json) {

        Matcher matcher = REGEX_ITEMS.matcher(json);
        if (!matcher.find()) {

            throw new IllegalArgumentException("Items not found!");
        }

        String[] items = matcher.group(1).split("\\},\\{");

        List<Map<String, String>> datas = new ArrayList<>();

        for (String item : items) {

            Map<String, String> attributesItem = new HashMap<>();

            Matcher matcherattributesJson = REGEX_ATTRIBUTES_JSON.matcher(item);
            while (matcherattributesJson.find()) {
                String atributo = matcherattributesJson.group(1);
                String valor = matcherattributesJson.group(2);
                attributesItem.put(atributo, valor);
            }

            datas.add(attributesItem);
        }

        return datas;

    }

}