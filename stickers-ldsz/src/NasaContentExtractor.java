import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NasaContentExtractor implements ContentExtractor{

    public List<Content> extractContents(String json) {

        // only extract the data that matters (title, poster, classification)
        var parser = new JsonParser();
        List<Map<String, String>> attributeList = parser.parse(json);

        List<Content> contents = new ArrayList<>();

        // pop content list

        for (Map<String, String> attributes : attributeList) {

            String title = attributes.get("title");
            String urlImage = attributes.get("url");
            var content = new Content(title, urlImage);

            contents.add(content);
        }

        return contents;
    }

}