import java.io.InputStream;
import java.net.URL;
import java.util.List;
public class App {    

    public static void main(String[] args) throws Exception {

        // Do HTTP connection and get the top 250 movies
        String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        ContentExtractor extractor = new ImdbContentExtractor();


        //String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/NASA-APOD.json";
        //String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/NASA-APOD.json";
        //ContentExtractor extractor = new NasaContentExtractor();

        var http = new ClientHttp();
        String json = http.searchData(url);        
        
        List<Content> contents = extractor.extractContents(json);

        var generator = new StickersGenerator();

        for (int i = 0; i < 3; i++) {

            Content content = contents.get(i);
                        
            InputStream inputStream = new URL(content.getUrlImage()).openStream();
            String fileName = "exit/" + content.getTitle() + ".png";

            generator.create(inputStream, fileName);

            System.out.println(content.getTitle());
            System.out.println();
        }

    }
}